package dev.fredyhg.raffleluteranosddd.domain.models.raffle;

import dev.fredyhg.raffleluteranosddd.common.domain.Aggregate;
import lombok.Getter;

import static dev.fredyhg.raffleluteranosddd.common.AssertionConcern.*;

@Getter
public class Raffle extends Aggregate<RaffleId> {
    private final String name;
    private final String imageUrl;
    private final Float price;
    private String orderId;

    public Raffle(String name, String imageUrl, Float price) {
        super(new RaffleId());
        assertArgumentMinLength(name, 3, "Raffle name size must not be less than 3 characters");
        assertArgumentNotNull(name, "Raffle name must not be null");

        assertArgumentNotEmpty(imageUrl, "Image url must not be empty");
        assertArgumentNotNull(imageUrl, "Image url must not be null");

        assertArgumentNotEmpty(imageUrl, "Price must not be empty");
        assertArgumentNotNull(imageUrl, "Price must not be null");

        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.orderId = null;
    }

    public void addOrderId(String orderId) {
        this.orderId = orderId;
    }
}
