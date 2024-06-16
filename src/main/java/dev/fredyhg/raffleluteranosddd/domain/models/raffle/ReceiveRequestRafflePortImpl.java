package dev.fredyhg.raffleluteranosddd.domain.models.raffle;

import dev.fredyhg.raffleluteranosddd.domain.ports.RafflePersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.ReceiveRequestRafflePort;

public class ReceiveRequestRafflePortImpl implements ReceiveRequestRafflePort {

    private final RafflePersistPort rafflePersistPort;

    public ReceiveRequestRafflePortImpl(RafflePersistPort rafflePersistPort) {
        this.rafflePersistPort = rafflePersistPort;
    }

    @Override
    public Raffle save(Raffle raffle) {
        rafflePersistPort.save(raffle);
        return raffle;
    }
}
