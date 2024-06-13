package dev.fredyhg.raffleluteranosddd.adapter.persistence;

import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.domain.ports.RafflePersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RafflePersistPortImpl implements RafflePersistPort {
    @Override
    public void save(Raffle raffle) {

    }
}
