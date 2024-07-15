package dev.fredyhg.raffleluteranosddd.adapter.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
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
    private boolean available;

    public RaffleModel(String id, String name, String imageUrl, BigDecimal price, boolean available) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.available = available;
    }

    public RaffleModel toggleSold() {
        this.available = false;
        return this;
    }

    protected RaffleModel() {
    }
}