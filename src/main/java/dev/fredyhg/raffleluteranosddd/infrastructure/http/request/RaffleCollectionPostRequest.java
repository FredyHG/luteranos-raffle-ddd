package dev.fredyhg.raffleluteranosddd.infrastructure.http.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RaffleCollectionPostRequest {
    @JsonProperty("collection_name")
    private String collectionName;
    private List<RafflePostRequest> raffles;

    public RaffleCollectionPostRequest(String raffleType, List<RafflePostRequest> raffles) {
        this.collectionName = raffleType;
        this.raffles = raffles;
    }
}
