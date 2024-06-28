package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleCollectionModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleCollectionRepository;
import dev.fredyhg.raffleluteranosddd.common.exception.RaffleCollectionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindRaffleCollectionByIdUseCase {

    private final RaffleCollectionRepository raffleCollectionRepository;

    public RaffleCollectionModel findById(String id) {
        return raffleCollectionRepository
                .findById(id)
                .orElseThrow(() -> new RaffleCollectionNotFoundException("Raffle collection not found"));
    }
}
