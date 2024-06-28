package dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection;

import dev.fredyhg.raffleluteranosddd.common.domain.Aggregate;
import dev.fredyhg.raffleluteranosddd.common.exception.RaffleWinnerAlreadyExistsException;
import dev.fredyhg.raffleluteranosddd.common.exception.UnfinishedRaffleInCollectionException;
import dev.fredyhg.raffleluteranosddd.domain.enums.RaffleCollectionStatus;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static dev.fredyhg.raffleluteranosddd.common.AssertionConcern.*;

@Getter
public class RaffleCollection extends Aggregate<RaffleCollectionId> {

    private final String collectionName;
    private final List<Raffle> raffles;
    private final Integer qntRaffle;
    private List<Raffle> availableRaffles = new ArrayList<>();
    private String orderWinner;
    private final LocalDateTime createdAt;
    private RaffleCollectionStatus status;

    public RaffleCollection(String collectionName, List<Raffle> raffles) {
        super(new RaffleCollectionId());

        assertArgumentNotNull(collectionName, "RaffleType cannot be null");
        assertArgumentNotEmpty(collectionName, "RaffleType cannot be empty");
        assertArgumentMinLength(collectionName, 3, "Collection name must be at least 3 characters");

        assertArgumentMinSize(raffles, 1, "Raffles cannot be empty");

        this.collectionName = collectionName;
        this.raffles = raffles;
        this.qntRaffle = raffles.size();
        this.createdAt = LocalDateTime.now();
        this.status = RaffleCollectionStatus.WAIT_FINISH;

        if(availableRaffles.isEmpty()) {
            this.availableRaffles = raffles;
        }
    }

    public RaffleCollection(String id,
                            String collectionName,
                            List<Raffle> raffles,
                            Integer qntRaffle,
                            LocalDateTime createdAt,
                            RaffleCollectionStatus status,
                            List<Raffle> availableRaffles) {

        super(new RaffleCollectionId(id));

        this.collectionName = collectionName;
        this.raffles = raffles;
        this.qntRaffle = qntRaffle;
        this.createdAt = createdAt;
        this.status = status;
        this.availableRaffles = availableRaffles;
    }

    public RaffleCollection genOrderWinner(){

        if(!availableRaffles.isEmpty()) {
            throw new UnfinishedRaffleInCollectionException("Raffle collection contains pending raffles");
        }

        if(orderWinner != null) {
            throw new RaffleWinnerAlreadyExistsException("This raffle already has a winner");
        }

        Random random = new Random();
        int winnerIndex = random.nextInt(raffles.size());

        this.orderWinner = raffles.get(winnerIndex).getOrderId();

        this.status = RaffleCollectionStatus.FINISH;

        return this;
    }
}
