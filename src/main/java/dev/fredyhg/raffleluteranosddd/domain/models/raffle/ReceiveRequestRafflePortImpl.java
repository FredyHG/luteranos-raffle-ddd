package dev.fredyhg.raffleluteranosddd.domain.models.raffle;

import dev.fredyhg.raffleluteranosddd.domain.ports.RafflePersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.ReceiveRequestRafflePort;

import java.util.List;

public class ReceiveRequestRafflePortImpl implements ReceiveRequestRafflePort {

    private final RafflePersistPort rafflePersistPort;

    public ReceiveRequestRafflePortImpl(RafflePersistPort rafflePersistPort) {
        this.rafflePersistPort = rafflePersistPort;
    }

    @Override
    public List<Raffle> saveAll(List<Raffle> raffle) {
        rafflePersistPort.saveAll(raffle);
        return raffle;
    }
}
