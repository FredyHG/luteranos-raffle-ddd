package dev.fredyhg.raffleluteranosddd.domain.ports;

import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;

import java.util.List;

public interface RafflePersistPort {
    void saveAll(List<Raffle> raffle);
}
