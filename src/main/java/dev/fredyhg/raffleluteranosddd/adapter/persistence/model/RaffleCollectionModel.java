package dev.fredyhg.raffleluteranosddd.adapter.persistence.model;

import dev.fredyhg.raffleluteranosddd.domain.enums.RaffleCollectionStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "tb_raffle_collection")
public class RaffleCollectionModel {
    @Id
    private String id;
    private String raffleType;
    @OneToMany
    @JoinColumn(name = "raffle_id")
    private List<RaffleModel> raffles;
    private Integer qntRaffle;

    @OneToMany
    @JoinColumn(name = "raffle_id")
    private List<RaffleModel> available;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private RaffleCollectionStatus status;

    public RaffleCollectionModel(String id,
                                 Integer qntRaffle,
                                 LocalDateTime createdAt,
                                 List<RaffleModel> raffles,
                                 String raffleType,
                                 RaffleCollectionStatus status,
                                 List<RaffleModel> available) {
        this.id = id;
        this.qntRaffle = qntRaffle;
        this.createdAt = createdAt;
        this.raffles = raffles;
        this.raffleType = raffleType;
        this.status = status;
        this.available = available;
    }

    protected RaffleCollectionModel() {}
}
