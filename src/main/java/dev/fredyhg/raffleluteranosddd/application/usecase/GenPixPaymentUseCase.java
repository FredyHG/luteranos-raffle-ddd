package dev.fredyhg.raffleluteranosddd.application.usecase;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.core.MPRequestOptions;
import com.mercadopago.resources.payment.Payment;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.OrderModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.BuyerRepository;
import dev.fredyhg.raffleluteranosddd.application.client.MercadoPagoClient;
import dev.fredyhg.raffleluteranosddd.application.properties.MercadoPagoProperties;
import dev.fredyhg.raffleluteranosddd.common.exception.BuyerNotFoundException;
import dev.fredyhg.raffleluteranosddd.common.exception.MercadoPagoClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GenPixPaymentUseCase {

    private final MercadoPagoProperties mercadoPagoProperties;

    private final MercadoPagoClient mercadoPagoClient;

    private final BuyerRepository buyerRepository;

    public Payment createPix(OrderModel orderModel) {

        BuyerModel buyer = buyerRepository
                .findById(orderModel.getBuyerId())
                .orElseThrow(() -> new BuyerNotFoundException("Buyer not found"));


        PaymentClient client = new PaymentClient();

        MercadoPagoConfig.setAccessToken(mercadoPagoProperties.getApiKey());
        PaymentCreateRequest paymentCreateRequest =
                createPaymentRequest(orderModel.getTotal(), orderModel.getId(), buyer);

        try {
            return client.create(paymentCreateRequest, setIdempotencyKey());
        } catch (Exception ex) {
            throw new MercadoPagoClientException("Error to create order");
        }
    }

    public PaymentCreateRequest createPaymentRequest(BigDecimal totalPrice,
                                                     String externalReference,
                                                     BuyerModel buyer) {

        OffsetDateTime now = OffsetDateTime.now();

        return PaymentCreateRequest.builder()
                .transactionAmount(totalPrice)
                .externalReference(externalReference)
                .paymentMethodId("pix")
                .dateOfExpiration(now.plusMinutes(10))
                .payer(
                        PaymentPayerRequest.builder()
                                .email(buyer.getEmail())
                                .firstName(buyer.getName())
                                .identification(
                                        IdentificationRequest
                                                .builder()
                                                .type("CPF")
                                                .number(buyer.getCpf())
                                                .build())
                                .build())
                .build();

    }

    private MPRequestOptions setIdempotencyKey(){
        Map<String, String> customHeaders = new HashMap<>();
        customHeaders.put("x-idempotency-key", UUID.randomUUID().toString());

        return MPRequestOptions.builder()
                .customHeaders(customHeaders)
                .build();
    }

}
