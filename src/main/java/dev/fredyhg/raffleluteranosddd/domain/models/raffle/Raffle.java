package dev.fredyhg.raffleluteranosddd.domain.models.raffle;

import dev.fredyhg.raffleluteranosddd.common.domain.Aggregate;
import lombok.Getter;

import java.math.BigDecimal;

import static dev.fredyhg.raffleluteranosddd.common.AssertionConcern.*;

@Getter
public class Raffle extends Aggregate<RaffleId> {
    private final String name;
    private final String imageBase64;
    private final BigDecimal price;
    private String orderId;

    public Raffle(String name, String imageBase64, BigDecimal price) {
        super(new RaffleId());
        assertArgumentMinLength(name, 3, "Raffle name size must not be less than 3 characters");
        assertArgumentNotNull(name, "Raffle name must not be null");

        assertArgumentNotEmpty(imageBase64, "Image url must not be empty");
        assertArgumentNotNull(imageBase64, "Image url must not be null");

        assertArgumentNotEmpty(imageBase64, "Price must not be empty");
        assertArgumentNotNull(imageBase64, "Price must not be null");

        this.name = name;
        this.imageBase64 = imageBase64;
        this.price = price;
        this.orderId = null;
    }

    public void addOrderId(String orderId) {
        this.orderId = orderId;
    }
}
