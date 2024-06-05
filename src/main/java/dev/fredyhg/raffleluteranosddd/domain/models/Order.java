package dev.fredyhg.raffleluteranosddd.domain.models;

import dev.fredyhg.raffleluteranosddd.common.domain.Aggregate;
import dev.fredyhg.raffleluteranosddd.domain.enums.OrderStatus;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class Order extends Aggregate<OrderId> {
    private final List<Raffle> raffles;
    private final UUID buyerId;
    private final LocalDateTime orderDate;
    private final Float total;
    private OrderStatus status;

    public Order(List<Raffle> raffles, OrderStatus status, Float total, LocalDateTime orderDate, UUID buyerId) {
        super(new OrderId());

        this.raffles = raffles;
        this.status = status;
        this.total = total;
        this.orderDate = orderDate;
        this.buyerId = buyerId;
    }

    public void changeStatus(OrderStatus status) {
        this.status = status;
    }
}
