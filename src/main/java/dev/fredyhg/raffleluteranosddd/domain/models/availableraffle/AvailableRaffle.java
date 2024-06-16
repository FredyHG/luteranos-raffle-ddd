package dev.fredyhg.raffleluteranosddd.domain.models.availableraffle;

import dev.fredyhg.raffleluteranosddd.common.domain.Aggregate;
import dev.fredyhg.raffleluteranosddd.domain.enums.AvailableRaffleStatus;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static dev.fredyhg.raffleluteranosddd.common.AssertionConcern.*;

@Getter
public class AvailableRaffle extends Aggregate<AvailableRaffleId> {

    private final String raffleType;
    private final List<Raffle> raffles;
    private final Integer qntRaffle;
    private List<Raffle> availableRaffles = new ArrayList<>();
    private final LocalDateTime createdAt;
    private final AvailableRaffleStatus status;

    public AvailableRaffle(String raffleType, List<Raffle> raffles) {
        super(new AvailableRaffleId());

        assertArgumentNotNull(raffleType, "RaffleType cannot be null");
        assertArgumentNotEmpty(raffleType, "RaffleType cannot be empty");
        assertArgumentMinLength(raffleType, 3, "RaffleType must be at least 3 characters");

        assertArgumentMinSize(raffles, 1, "Raffles cannot be empty");

        this.raffleType = raffleType;
        this.raffles = raffles;
        this.qntRaffle = raffles.size();
        this.createdAt = LocalDateTime.now();
        this.status = AvailableRaffleStatus.WAIT_FINISH;

        if(availableRaffles.isEmpty()) {
            this.availableRaffles = raffles;
        }
    }
}
