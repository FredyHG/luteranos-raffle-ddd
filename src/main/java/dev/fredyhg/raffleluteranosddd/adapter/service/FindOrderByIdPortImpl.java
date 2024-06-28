package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.OrderModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.OrderRepository;
import dev.fredyhg.raffleluteranosddd.common.exception.OrderNotFoundException;
import dev.fredyhg.raffleluteranosddd.common.mapper.OrderMapper;
import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.Order;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.domain.ports.FindOrderByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class FindOrderByIdPortImpl implements FindOrderByIdPort {

    private final OrderRepository orderRepository;

    @Override
    public Order findById(String id) {

        OrderModel order = orderRepository
                .findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        List<Raffle> listOfRaffle = order.getRaffles().stream().map(RaffleMapper::modelToRaffle).toList();

        return OrderMapper.modelToOrder(order, listOfRaffle, order.getCollectionId());
    }
}
