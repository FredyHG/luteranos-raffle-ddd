package dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection;

import dev.fredyhg.raffleluteranosddd.domain.ports.RaffleCollectionPersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.RequestRaffleCollectionReceiverPort;

public class RaffleCollectionReceiverPortImpl implements RequestRaffleCollectionReceiverPort {

    private final RaffleCollectionPersistPort raffleCollectionPersistPort;

    public RaffleCollectionReceiverPortImpl(RaffleCollectionPersistPort raffleCollectionPersistPort) {
        this.raffleCollectionPersistPort = raffleCollectionPersistPort;
    }

    @Override
    public RaffleCollection save(RaffleCollection raffleCollection) {
        raffleCollectionPersistPort.save(raffleCollection);
        return raffleCollection;
    }
}
