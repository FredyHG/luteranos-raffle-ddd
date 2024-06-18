package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.OrderModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.OrderRepository;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.mapper.OrderMapper;
import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.Order;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.domain.ports.OrderPersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class OrderPersistPortImpl implements OrderPersistPort {

    private final OrderRepository orderRepository;
    private final RaffleRepository raffleRepository;

    @Override
    public Order save(Order order) {

        List<RaffleModel> raffles = order.getRaffles().stream().map(
                raf -> raffleRepository.findById(raf.getId().fromValue()).orElseThrow(
                        () -> new RuntimeException("Raffle not found"))).toList();

        OrderModel orderModel = OrderMapper.toModel(order, raffles);
        OrderModel savedOrder = orderRepository.save(orderModel);

        for (RaffleModel raffle : raffles) {
            raffle.setOrder(savedOrder);
            raffleRepository.save(raffle);
        }

        List<Raffle> listOfRaffle = savedOrder.getRaffles().stream().map(RaffleMapper::modelToRaffle).toList();

        return OrderMapper.modelToOrder(savedOrder, listOfRaffle);
    }
}
