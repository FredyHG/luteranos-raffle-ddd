package dev.fredyhg.raffleluteranosddd.adapter.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tb_raffle")
public class RaffleModel {

    @Id
    private String id;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel order;

    @ManyToOne
    @JoinColumn(name = "available_raffle_id")
    private AvailableRaffleModel typeRaffle;

}
