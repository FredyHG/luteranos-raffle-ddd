package dev.fredyhg.raffleluteranosddd.domain.ports;

import dev.fredyhg.raffleluteranosddd.domain.models.Order;

public interface RequestOrderReceiverPort {
    Order save(Order order);
}
