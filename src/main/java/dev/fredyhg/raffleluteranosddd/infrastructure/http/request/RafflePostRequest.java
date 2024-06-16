package dev.fredyhg.raffleluteranosddd.infrastructure.http.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RafflePostRequest {
    private String name;
    private String base64Image;
    private BigDecimal price;
}
