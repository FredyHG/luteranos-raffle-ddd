package dev.fredyhg.raffleluteranosddd.adapter.persistence.model;

import dev.fredyhg.raffleluteranosddd.domain.enums.AvailableRaffleStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "tb_available_raffle")
public class AvailableRaffleModel {
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
    private AvailableRaffleStatus status;

    public AvailableRaffleModel(String id, Integer qntRaffle, LocalDateTime createdAt, List<RaffleModel> raffles, String raffleType, AvailableRaffleStatus status, List<RaffleModel> available) {
        this.id = id;
        this.qntRaffle = qntRaffle;
        this.createdAt = createdAt;
        this.raffles = raffles;
        this.raffleType = raffleType;
        this.status = status;
        this.available = available;
    }

    protected AvailableRaffleModel() {}
}
