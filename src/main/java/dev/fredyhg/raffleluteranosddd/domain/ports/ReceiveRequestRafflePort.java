package dev.fredyhg.raffleluteranosddd.domain.ports;

import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;

public interface ReceiveRequestRafflePort {
    Raffle save(Raffle raffle);
}
