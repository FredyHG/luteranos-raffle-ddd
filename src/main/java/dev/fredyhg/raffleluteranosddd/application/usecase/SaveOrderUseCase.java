package dev.fredyhg.raffleluteranosddd.application.usecase;

import com.mercadopago.resources.payment.Payment;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.OrderModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.BuyerRepository;
import dev.fredyhg.raffleluteranosddd.common.mapper.BuyerMapper;
import dev.fredyhg.raffleluteranosddd.common.mapper.OrderMapper;
import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.Order;
import dev.fredyhg.raffleluteranosddd.domain.models.buyer.Buyer;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.domain.ports.RequestOrderReceiverPort;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.OrderPostRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.BuyRaffleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class SaveOrderUseCase {

    private final RequestOrderReceiverPort requestOrderReceiverPort;
    private final FindRaffleByIdUseCase findRaffleByIdUseCase;
    private final BuyerRepository buyerRepository;
    private final SaveBuyerUseCase saveBuyerUseCase;
    private final GenPixPaymentUseCase genPixPaymentUseCase;

    public BuyRaffleResponse createOrder(OrderPostRequest orderPostRequest) {

        log.info("Searching buyer with cpf: {}", orderPostRequest.getBuyer().getCpf());
        Optional<BuyerModel> buyerModel = buyerRepository.findByCpf(orderPostRequest.getBuyer().getCpf());

        log.info("Create a buyer if one does not already exist.");
        Buyer buyer = buyerModel.map(BuyerMapper::modelToBuyer).orElseGet(() -> saveBuyerUseCase.save(orderPostRequest.getBuyer()));

        List<RaffleModel> listOfModels = orderPostRequest.getRafflesIds().stream().map(findRaffleByIdUseCase::findById).toList();
        List<Raffle> listOfRaffle = listOfModels.stream().map(RaffleMapper::modelToRaffle).toList();

        Order order = OrderMapper.toOrder(buyer, listOfRaffle, orderPostRequest.getCollectionId());

        Order savedOrder = requestOrderReceiverPort.save(order);

        OrderModel orderModel = OrderMapper.toModel(savedOrder, listOfModels);

        Payment pix = genPixPaymentUseCase.createPix(orderModel);

        return BuyRaffleResponse
                .builder()
                .buyerName(buyer.getName())
                .qrCodeBase64(pix.getPointOfInteraction().getTransactionData().getQrCodeBase64())
                .pixPaymentLink(pix.getPointOfInteraction().getTransactionData().getQrCode())
                .build();
    }
}
