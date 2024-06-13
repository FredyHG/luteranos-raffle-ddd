package dev.fredyhg.raffleluteranosddd.adapter.persistence;

import dev.fredyhg.raffleluteranosddd.domain.models.Order;
import dev.fredyhg.raffleluteranosddd.domain.ports.OrderPersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderPersistPortImpl implements OrderPersistPort {
    @Override
    public void save(Order order) {

    }
}
