package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.OrderModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.OrderRepository;
import dev.fredyhg.raffleluteranosddd.application.properties.MercadoPagoProperties;
import dev.fredyhg.raffleluteranosddd.common.exception.OrderNotFoundException;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.MercadoPagoResponse;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.PaymentGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentCallBackPostUseCase {

    private final OrderRepository orderRepository;
    private final MercadoPagoProperties mercadoPagoProperties;

    public void checkPayment(MercadoPagoResponse mercadoPagoResponse) {

        PaymentGetResponse paymentGetResponse = new PaymentGetResponse();
//                mercadoPagoClient.checkPaymentStatus(
//                        mercadoPagoResponse.getData().getId(),
//                        mercadoPagoProperties.getTypeToken() + mercadoPagoProperties.getApiKey());

        OrderModel order = orderRepository
                .findById(mercadoPagoResponse.getExternalReference())
                .orElseThrow(() -> new OrderNotFoundException("Order not found "));

        if(paymentGetResponse.getStatus().equals("pending")) {
            return;
        }

        if(paymentGetResponse.getStatus().equals("approved")){
//            toggleSold(raffles);
        }

        if(paymentGetResponse.getStatus().equals("rejected") || paymentGetResponse.getStatus().equals("cancelled")) {

        }
    }

}
