package dev.fredyhg.raffleluteranosddd.adapter.persistence;

import dev.fredyhg.raffleluteranosddd.domain.models.buyer.Buyer;
import dev.fredyhg.raffleluteranosddd.domain.ports.BuyerPersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuyerPersistPortImpl implements BuyerPersistPort {
    @Override
    public void save(Buyer buyer) {

    }
}
