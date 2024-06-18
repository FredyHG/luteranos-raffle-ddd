package dev.fredyhg.raffleluteranosddd.domain.ports;

import dev.fredyhg.raffleluteranosddd.domain.models.Order;

public interface OrderPersistPort {
    Order save(Order order);
}
