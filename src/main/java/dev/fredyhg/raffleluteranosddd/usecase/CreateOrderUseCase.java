package dev.fredyhg.raffleluteranosddd.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final RequestOrderReceiverPort requestOrderReceiverPort;
    private final FindRaffleByIdUseCase findRaffleByIdUseCase;
    private final BuyerRepository buyerRepository;
    private final SaveBuyerUseCase saveBuyerUseCase;

    public Order save(OrderPostRequest orderPostRequest) {
        Optional<BuyerModel> buyerModel = buyerRepository.findByCpf(orderPostRequest.getBuyer().getCpf());

        Buyer buyer = buyerModel.map(BuyerMapper::modelToMapper).orElseGet(() -> saveBuyerUseCase.save(orderPostRequest.getBuyer()));

        List<RaffleModel> listOfModels = orderPostRequest.getRafflesIds().stream().map(findRaffleByIdUseCase::findById).toList();
        List<Raffle> listOfRaffle = listOfModels.stream().map(RaffleMapper::modelToRaffle).toList();

        Order order = OrderMapper.toOrder(buyer, listOfRaffle);


        return requestOrderReceiverPort.save(order);
    }
}
