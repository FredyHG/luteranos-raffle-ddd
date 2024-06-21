package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.domain.ports.RafflePersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RafflePersistPortImpl implements RafflePersistPort {

    private final RaffleRepository raffleRepository;
    @Override
    public void saveAll(List<Raffle> raffles) {

        List<RaffleModel> listRafflesToBeSaved =
                raffles.stream().map(RaffleMapper::toRaffleModel).toList();

        raffleRepository.saveAll(listRafflesToBeSaved);
    }
}
