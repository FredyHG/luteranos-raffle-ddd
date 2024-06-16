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
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<RaffleModel> raffles;
    private LocalDateTime buyAt;
    private BigDecimal total;
    private OrderStatus status;

    public OrderModel(List<RaffleModel> raffles) {
        this.status = OrderStatus.WAIT_PAYMENT;
        this.buyAt = null;
        this.raffles = raffles;
        this.total = getTotal(raffles);
    }

    public OrderModel() {
    }

    public BigDecimal getTotal(List<RaffleModel> raffles) {
        return raffles.stream()
                .map(RaffleModel::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
