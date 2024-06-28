package dev.fredyhg.raffleluteranosddd.adapter.persistence.model;

import dev.fredyhg.raffleluteranosddd.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_order")
public class OrderModel {

    @Id
    private String id;

    private String collectionId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<RaffleModel> raffles;
    private LocalDateTime buyAt;
    private String buyerId;
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDateTime creatAt;

    @PrePersist
    private void onCreate(){
        this.creatAt = LocalDateTime.now();
    }

    public OrderModel(List<RaffleModel> raffles, String buyerId, String id, String collectionId) {
        this.id = id;
        this.collectionId = collectionId;
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
