package dev.fredyhg.raffleluteranosddd.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleCollectionModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleCollectionRepository;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.exception.RaffleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindRafflesByRaffleTypeUseCase {

    private final RaffleRepository raffleRepository;
    private final RaffleCollectionRepository raffleCollectionRepository;

    public Page<RaffleModel> findRafflesByRaffleType(String typeRaffle, Pageable pageable){

        RaffleCollectionModel raffleCollection = raffleCollectionRepository
                .findByRaffleType(typeRaffle).orElseThrow(
                        () -> new RaffleNotFoundException("Raffle not found"));

        return raffleRepository.findByRaffleId(raffleCollection.getId(), pageable);
    }

}
