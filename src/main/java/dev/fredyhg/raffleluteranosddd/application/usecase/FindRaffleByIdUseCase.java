package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.exception.RaffleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindRaffleByIdUseCase {

    private final RaffleRepository raffleRepository;

    public RaffleModel findById(String id) {
        return raffleRepository.findById(id).orElseThrow(() -> new RaffleNotFoundException("Raffle not found"));
    }

}
