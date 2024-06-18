package dev.fredyhg.raffleluteranosddd.domain.models.availableraffle;

import dev.fredyhg.raffleluteranosddd.domain.ports.AvailableRafflePersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.RequestAvailableRaffleReceiverPort;

public class RequestAvailableRaffleReceiverPortImpl implements RequestAvailableRaffleReceiverPort {

    private final AvailableRafflePersistPort availableRafflePersistPort;

    public RequestAvailableRaffleReceiverPortImpl(AvailableRafflePersistPort availableRafflePersistPort) {
        this.availableRafflePersistPort = availableRafflePersistPort;
    }

    @Override
    public AvailableRaffle save(AvailableRaffle availableRaffle) {
        availableRafflePersistPort.save(availableRaffle);
        return availableRaffle;
    }
}
