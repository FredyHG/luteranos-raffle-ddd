package dev.fredyhg.raffleluteranosddd.domain.models.raffle;

import dev.fredyhg.raffleluteranosddd.domain.ports.RafflePersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.RequestRaffleReceiverPort;

import java.util.List;

public class RequestRaffleReceiverPortImpl implements RequestRaffleReceiverPort {

    private final RafflePersistPort rafflePersistPort;

    public RequestRaffleReceiverPortImpl(RafflePersistPort rafflePersistPort) {
        this.rafflePersistPort = rafflePersistPort;
    }

    @Override
    public List<Raffle> saveAll(List<Raffle> raffle) {
        rafflePersistPort.saveAll(raffle);
        return raffle;
    }
}
