package dev.fredyhg.raffleluteranosddd.infrastructure.http.response;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RaffleCollectionGetRequest {
    private String id;
    private String raffleType;
    private Integer qntRaffle;
    private List<RaffleModel> availableRaffles;
    private LocalDateTime createdAt;
    private String status;

    public RaffleCollectionGetRequest(String id, LocalDateTime createdAt, String status, String raffleType, Integer qntRaffle, List<RaffleModel> availableRaffles) {
        this.id = id;
        this.createdAt = createdAt;
        this.status = status;
        this.raffleType = raffleType;
        this.qntRaffle = qntRaffle;
        this.availableRaffles = availableRaffles;
    }

    public RaffleCollectionGetRequest() {
    }
}
