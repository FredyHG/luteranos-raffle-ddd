package dev.fredyhg.raffleluteranosddd.domain.models;

import dev.fredyhg.raffleluteranosddd.common.domain.Aggregate;
import dev.fredyhg.raffleluteranosddd.domain.enums.OrderStatus;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Order extends Aggregate<OrderId> {
    private final String collectionId;
    private List<Raffle> raffles;
    private final String buyerId;
    private final LocalDateTime orderDate;
    private final BigDecimal total;
    private OrderStatus status;

    public Order(List<Raffle> raffles, String buyerId, String collectionId) {
        super(new OrderId());

        this.collectionId = collectionId;
        this.raffles = raffles;
        this.status = OrderStatus.WAIT_PAYMENT;
        this.total = Raffle.getSumTotal(raffles);
        this.orderDate = LocalDateTime.now();
        this.buyerId = buyerId;

        this.raffles.forEach(Raffle::removeAvailable);
    }

    public Order(String collectionId, String id, BigDecimal total, OrderStatus status, LocalDateTime orderDate, String buyerId, List<Raffle> raffles) {
        super(new OrderId(id));
        this.collectionId = collectionId;
        this.total = total;
        this.status = status;
        this.orderDate = orderDate;
        this.buyerId = buyerId;
        this.raffles = raffles;
    }

    public void changeStatus(OrderStatus status) {
        this.status = status;
    }

    public Order setRaffles(List<Raffle> raffles) {
        this.raffles = raffles;
        return this;
    }

}
