package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindBuyerByCpfUseCase {

    private final BuyerRepository buyerRepository;

    public BuyerModel findBuyerByCpf(String cpf) {
        return buyerRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Buyer not found"));
    }

}
