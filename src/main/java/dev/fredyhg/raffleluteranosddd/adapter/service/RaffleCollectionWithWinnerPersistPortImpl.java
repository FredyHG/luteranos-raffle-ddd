package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.OrderModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleCollectionModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.BuyerRepository;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.OrderRepository;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleCollectionRepository;
import dev.fredyhg.raffleluteranosddd.common.exception.BuyerNotFoundException;
import dev.fredyhg.raffleluteranosddd.common.exception.OrderNotFoundException;
import dev.fredyhg.raffleluteranosddd.common.exception.RaffleCollectionException;
import dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection.RaffleCollection;
import dev.fredyhg.raffleluteranosddd.domain.ports.RaffleCollectionWithWinnerPersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RaffleCollectionWithWinnerPersistPortImpl implements RaffleCollectionWithWinnerPersistPort {

    private final RaffleCollectionRepository raffleCollectionRepository;
    private final OrderRepository orderRepository;
    private final BuyerRepository buyerRepository;

    @Override
    public RaffleCollection persistWithWinner(RaffleCollection raffleCollection) {

        RaffleCollectionModel raffleCollectionExists = raffleCollectionRepository
                .findById(raffleCollection.getId().fromValue())
                .orElseThrow(() -> new RaffleCollectionException("Raffle Collection not found"));

        OrderModel order = orderRepository
                .findById(raffleCollection.getOrderWinner())
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        BuyerModel buyer = buyerRepository
                .findById(order.getBuyerId())
                .orElseThrow(() -> new BuyerNotFoundException("Buyer not found"));

        raffleCollectionExists.setWinner(buyer);

        raffleCollectionRepository.save(raffleCollectionExists);

        return raffleCollection;
    }
}
