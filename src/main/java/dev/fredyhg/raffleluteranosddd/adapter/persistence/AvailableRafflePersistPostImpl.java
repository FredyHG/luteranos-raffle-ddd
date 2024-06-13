package dev.fredyhg.raffleluteranosddd.adapter.persistence;

import dev.fredyhg.raffleluteranosddd.domain.models.availableraffle.AvailableRaffle;
import dev.fredyhg.raffleluteranosddd.domain.ports.AvailableRafflePersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AvailableRafflePersistPostImpl implements AvailableRafflePersistPort {
    @Override
    public void save(AvailableRaffle availableRaffle) {

    }
}
