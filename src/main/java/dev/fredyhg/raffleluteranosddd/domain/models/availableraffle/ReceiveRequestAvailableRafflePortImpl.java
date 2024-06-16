package dev.fredyhg.raffleluteranosddd.domain.models.availableraffle;

import dev.fredyhg.raffleluteranosddd.domain.ports.AvailableRafflePersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.ReceiveRequestAvailableRafflePort;

public class ReceiveRequestAvailableRafflePortImpl implements ReceiveRequestAvailableRafflePort {

    private final AvailableRafflePersistPort availableRafflePersistPort;

    public ReceiveRequestAvailableRafflePortImpl(AvailableRafflePersistPort availableRafflePersistPort) {
        this.availableRafflePersistPort = availableRafflePersistPort;
    }

    @Override
    public AvailableRaffle save(AvailableRaffle availableRaffle) {
        availableRafflePersistPort.save(availableRaffle);
        return availableRaffle;
    }
}
