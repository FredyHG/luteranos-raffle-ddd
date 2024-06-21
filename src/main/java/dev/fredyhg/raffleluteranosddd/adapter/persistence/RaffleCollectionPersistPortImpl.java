package dev.fredyhg.raffleluteranosddd.adapter.persistence;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleCollectionRepository;
import dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection.RaffleCollection;
import dev.fredyhg.raffleluteranosddd.domain.ports.RaffleCollectionPersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RaffleCollectionPersistPortImpl implements RaffleCollectionPersistPort {

    private final RaffleCollectionRepository raffleCollectionRepository;

    @Override
    public void save(RaffleCollection availableRaffle) {

    }
}
