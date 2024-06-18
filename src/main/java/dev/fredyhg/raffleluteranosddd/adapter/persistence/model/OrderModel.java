package dev.fredyhg.raffleluteranosddd.adapter.persistence.model;

import dev.fredyhg.raffleluteranosddd.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "tb_order")
public class OrderModel {

    @Id
    private String id;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<RaffleModel> raffles;
    private LocalDateTime buyAt;
    private String buyerId;
    private BigDecimal total;
    private OrderStatus status;

    public OrderModel(List<RaffleModel> raffles, String buyerId, String id) {
        this.id = id;
        this.status = OrderStatus.WAIT_PAYMENT;
        this.buyAt = null;
        this.raffles = raffles;
        this.total = getTotal(raffles);
        this.buyerId = buyerId;
        this.setRaffleOrderReference(raffles);
    }

    public OrderModel() {
    }

    private void setRaffleOrderReference(List<RaffleModel> raffles) {
        for (RaffleModel raffle : raffles) {
            raffle.setOrder(this);
        }
    }

    public BigDecimal getTotal(List<RaffleModel> raffles) {
        return raffles.stream()
                .map(RaffleModel::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
