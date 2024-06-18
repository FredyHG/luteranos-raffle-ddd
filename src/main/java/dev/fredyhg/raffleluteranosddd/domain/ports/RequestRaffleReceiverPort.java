package dev.fredyhg.raffleluteranosddd.domain.ports;

import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;

import java.util.List;

public interface RequestRaffleReceiverPort {
    List<Raffle> saveAll(List<Raffle> raffle);
}
