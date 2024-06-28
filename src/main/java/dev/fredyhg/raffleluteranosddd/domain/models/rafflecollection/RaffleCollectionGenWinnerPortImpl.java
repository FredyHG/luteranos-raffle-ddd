package dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection;

import dev.fredyhg.raffleluteranosddd.domain.ports.RaffleCollectionGenWinnerPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.RaffleCollectionWithWinnerPersistPort;

public class RaffleCollectionGenWinnerPortImpl implements RaffleCollectionGenWinnerPort {

    private final RaffleCollectionWithWinnerPersistPort raffleCollectionWithWinnerPersistPort;

    public RaffleCollectionGenWinnerPortImpl(RaffleCollectionWithWinnerPersistPort raffleCollectionWithWinnerPersistPort) {
        this.raffleCollectionWithWinnerPersistPort = raffleCollectionWithWinnerPersistPort;

    }

    @Override
    public RaffleCollection genRaffleCollectionWinner(RaffleCollection raffleCollection) {

        RaffleCollection raffleWithWinner = raffleCollection.genOrderWinner();

        raffleCollectionWithWinnerPersistPort.persistWithWinner(raffleWithWinner);

        return raffleWithWinner;
    }
}
