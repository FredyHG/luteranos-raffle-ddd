package dev.fredyhg.raffleluteranosddd.domain.ports;

import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;

public interface RafflePersistPort {
    void save(Raffle raffle);
}
