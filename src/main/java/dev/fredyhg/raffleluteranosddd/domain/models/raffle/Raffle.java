package dev.fredyhg.raffleluteranosddd.domain.models.raffle;

import dev.fredyhg.raffleluteranosddd.common.domain.Aggregate;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

import static dev.fredyhg.raffleluteranosddd.common.AssertionConcern.*;

@Getter
public class Raffle extends Aggregate<RaffleId> {
    private final String name;
    private final String imageBase64;
    private String imageUrl;
    private final BigDecimal price;
    private String orderId;
    private boolean available;

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
        this.available = true;
    }

    public Raffle(String id, BigDecimal price, String imageBase64, String name, boolean available) {
        super(new RaffleId(id));
        this.price = price;
        this.imageBase64 = imageBase64;
        this.name = name;
        this.available = available;
    }

    public static BigDecimal getSumTotal(List<Raffle> raffles) {
        BigDecimal total = BigDecimal.ZERO;
        for (Raffle raffle : raffles) {
            total = total.add(raffle.getPrice());
        }

        return total;
    }

    public Raffle setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Raffle removeAvailable() {
        this.available = false;
        return this;
    }
}
