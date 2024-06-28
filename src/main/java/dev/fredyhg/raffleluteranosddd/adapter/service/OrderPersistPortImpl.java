package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.OrderModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleCollectionModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.OrderRepository;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleCollectionRepository;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.exception.RaffleCollectionNotFoundException;
import dev.fredyhg.raffleluteranosddd.common.mapper.OrderMapper;
import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.Order;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.domain.ports.OrderPersistPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderPersistPortImpl implements OrderPersistPort {

    private final OrderRepository orderRepository;
    private final RaffleRepository raffleRepository;
    private final RaffleCollectionRepository raffleCollectionRepository;

    @Transactional
    @Override
    public Order save(Order order) {

        List<RaffleModel> raffles = order.getRaffles().stream().map(
                raf -> raffleRepository.findById(raf.getId().fromValue()).orElseThrow(
                        () -> new RuntimeException("Raffle not found"))).toList();


        OrderModel orderModel = OrderMapper.toModel(order, raffles);

        log.info("Saving order with id: {}", orderModel.getId());
        OrderModel savedOrder = orderRepository.save(orderModel);

        for (RaffleModel raffle : raffles) {
            raffle.setOrder(savedOrder);
            raffle.setAvailable(false);
            raffleRepository.save(raffle);
        }

        List<Raffle> listOfRaffle = savedOrder.getRaffles().stream().map(RaffleMapper::modelToRaffle).toList();

        return OrderMapper.modelToOrder(savedOrder, listOfRaffle, savedOrder.getCollectionId());
    }
}
