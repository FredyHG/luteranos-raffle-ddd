package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.BuyerRepository;
import dev.fredyhg.raffleluteranosddd.common.mapper.BuyerMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.buyer.Buyer;
import dev.fredyhg.raffleluteranosddd.domain.ports.BuyerPersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BuyerPersistPortImpl implements BuyerPersistPort {

    private final BuyerRepository buyerRepository;

    @Override
    public void save(Buyer buyer) {
        BuyerModel buyerModel = BuyerMapper.toModel(buyer);
        buyerRepository.save(buyerModel);
    }
}
