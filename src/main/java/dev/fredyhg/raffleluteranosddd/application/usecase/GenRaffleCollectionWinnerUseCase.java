package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.OrderModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleCollectionModel;
import dev.fredyhg.raffleluteranosddd.common.mapper.BuyerMapper;
import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleCollectionMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection.RaffleCollection;
import dev.fredyhg.raffleluteranosddd.domain.ports.RaffleCollectionGenWinnerPort;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.WinnerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenRaffleCollectionWinnerUseCase {

    private final RaffleCollectionGenWinnerPort raffleCollectionGenWinnerPort;
    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final FindBuyerByIdUseCase findBuyerByIdUseCase;
    private final FindRaffleCollectionByIdUseCase findRaffleCollectionByIdUseCase;

    public WinnerResponse genWinner(String collectionId) {

        RaffleCollectionModel raffleCollectionExists = findRaffleCollectionByIdUseCase.findById(collectionId);

        RaffleCollection raffleCollection = RaffleCollectionMapper.modelToRaffleCollection(raffleCollectionExists);

        RaffleCollection raffleCollectionWithWinner = raffleCollectionGenWinnerPort.genRaffleCollectionWinner(raffleCollection);

        OrderModel order = findOrderByIdUseCase.findById(raffleCollectionWithWinner.getOrderWinner());

        BuyerModel buyer = findBuyerByIdUseCase.findById(order.getBuyerId());


        return WinnerResponse.builder()
                .orderId(raffleCollection.getId().fromValue())
                .buyer(BuyerMapper.modelToDto(buyer))
                .build();
    }


}