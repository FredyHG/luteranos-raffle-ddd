package dev.fredyhg.raffleluteranosddd.adapter.persistence.model;

import dev.fredyhg.raffleluteranosddd.domain.enums.RaffleCollectionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_raffle_collection")
public class RaffleCollectionModel {
    @Id
    private String id;
    private String collectionName;
    @OneToMany
    @JoinColumn(name = "raffle_id")
    private List<RaffleModel> raffles;
    private Integer qntRaffle;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private RaffleCollectionStatus status;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private BuyerModel winner;

    public RaffleCollectionModel(String id,
                                 Integer qntRaffle,
                                 LocalDateTime createdAt,
                                 List<RaffleModel> raffles,
                                 String collectionName,
                                 RaffleCollectionStatus status) {
        this.id = id;
        this.qntRaffle = qntRaffle;
        this.createdAt = createdAt;
        this.raffles = raffles;
        this.collectionName = collectionName;
        this.status = status;
    }

    protected RaffleCollectionModel() {}
}
