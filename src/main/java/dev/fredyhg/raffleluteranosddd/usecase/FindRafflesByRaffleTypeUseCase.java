package dev.fredyhg.raffleluteranosddd.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.AvailableRaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.AvailableRaffleRepository;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindRafflesByRaffleTypeUseCase {

    private final RaffleRepository raffleRepository;
    private final AvailableRaffleRepository availableRaffleRepository;

    public Page<RaffleModel> findRafflesByRaffleType(String typeRaffle, Pageable pageable){

        Optional<AvailableRaffleModel> availableRaffle = availableRaffleRepository.findByRaffleType(typeRaffle);

        if(availableRaffle.isEmpty()) {
            throw new RuntimeException("Raffle type not found");
        }

        return raffleRepository.findByRaffleId(availableRaffle.get().getId(), pageable);
    }

}
