package dev.fredyhg.raffleluteranosddd.infrastructure.http.request;

import lombok.Data;

import java.util.List;

@Data
public class RaffleCollectionPostRequest {
    private String raffleType;
    private List<RafflePostRequest> raffles;

    public RaffleCollectionPostRequest(String raffleType, List<RafflePostRequest> raffles) {
        this.raffleType = raffleType;
        this.raffles = raffles;
    }
}
