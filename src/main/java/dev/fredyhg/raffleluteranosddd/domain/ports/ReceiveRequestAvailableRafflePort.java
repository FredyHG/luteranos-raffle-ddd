package dev.fredyhg.raffleluteranosddd.domain.ports;

import dev.fredyhg.raffleluteranosddd.domain.models.availableraffle.AvailableRaffle;

public interface ReceiveRequestAvailableRafflePort {
    AvailableRaffle save(AvailableRaffle availableRaffle);
}
