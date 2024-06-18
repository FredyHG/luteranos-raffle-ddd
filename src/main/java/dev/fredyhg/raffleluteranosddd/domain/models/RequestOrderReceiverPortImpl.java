package dev.fredyhg.raffleluteranosddd.domain.models;

import dev.fredyhg.raffleluteranosddd.domain.ports.OrderPersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.RequestOrderReceiverPort;

public class RequestOrderReceiverPortImpl implements RequestOrderReceiverPort {

    private final OrderPersistPort orderPersistPort;

    public RequestOrderReceiverPortImpl(OrderPersistPort orderPersistPort) {
        this.orderPersistPort = orderPersistPort;
    }

    @Override
    public Order save(Order order) {
        orderPersistPort.save(order);

        return order;
    }
}
