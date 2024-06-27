package dev.fredyhg.raffleluteranosddd.domain.service;

import dev.fredyhg.raffleluteranosddd.domain.models.Order;
import dev.fredyhg.raffleluteranosddd.domain.ports.FindOrderByIdPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {

    private final FindOrderByIdPort findOrderByIdPort;

    public Order findById(String id) {
        return findOrderByIdPort.findById(id);
    }
}
