package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.BuyerRepository;
import dev.fredyhg.raffleluteranosddd.common.exception.BuyerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindBuyerByIdUseCase {

    private final BuyerRepository buyerRepository;

    public BuyerModel findById(String id) {
        return buyerRepository.findById(id).orElseThrow(() -> new BuyerNotFoundException("Order not found"));
    }

}
