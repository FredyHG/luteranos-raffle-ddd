package dev.fredyhg.raffleluteranosddd.infrastructure.http.response;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RaffleCollectionGetRequest {
    private String id;
    private String raffleType;
    private Integer qntRaffle;
    private List<RaffleModel> raffles;
    private LocalDateTime createdAt;
    private String status;

    public RaffleCollectionGetRequest(String id, LocalDateTime createdAt, String status, String raffleType, Integer qntRaffle, List<RaffleModel> raffles) {
        this.id = id;
        this.createdAt = createdAt;
        this.status = status;
        this.raffleType = raffleType;
        this.qntRaffle = qntRaffle;
        this.raffles = raffles;
    }

    private RaffleCollectionGetRequest() {
    }
}
