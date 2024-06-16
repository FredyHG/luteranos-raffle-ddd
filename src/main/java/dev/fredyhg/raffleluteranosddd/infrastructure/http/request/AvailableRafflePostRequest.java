package dev.fredyhg.raffleluteranosddd.infrastructure.http.request;

import lombok.Data;

import java.util.List;

@Data
public class AvailableRafflePostRequest {
    private String raffleType;
    private List<RafflePostRequest> raffles;
}
