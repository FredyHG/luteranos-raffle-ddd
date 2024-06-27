package dev.fredyhg.raffleluteranosddd.domain.ports;

import dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection.RaffleCollection;

public interface RaffleCollectionWithWinnerPersistPort {
    RaffleCollection persistWithWinner(RaffleCollection raffleCollection);
}
