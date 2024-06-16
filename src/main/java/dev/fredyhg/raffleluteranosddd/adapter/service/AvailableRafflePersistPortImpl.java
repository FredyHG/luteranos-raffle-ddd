package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.AvailableRaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.AvailableRaffleRepository;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.mapper.AvailableRaffleMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.availableraffle.AvailableRaffle;
import dev.fredyhg.raffleluteranosddd.domain.ports.AvailableRafflePersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AvailableRafflePersistPortImpl implements AvailableRafflePersistPort {

    private final AvailableRaffleRepository availableRaffleRepository;
    private final RaffleRepository raffleRepository;

    @Override
    public void save(AvailableRaffle availableRaffle) {

        List<RaffleModel> raffles = availableRaffle.getRaffles().stream().map(raffle ->
                        raffleRepository.findById(raffle.getId().fromValue()).orElseThrow(() -> new RuntimeException("Raffle not found")))
                .toList();

        List<RaffleModel> availableRaffles = availableRaffle.getAvailableRaffles().stream().map(raffle ->
                        raffleRepository.findById(raffle.getId().fromValue()).orElseThrow(() -> new RuntimeException("Raffle not found")))
                .toList();

        AvailableRaffleModel availableRaffleModel = AvailableRaffleMapper.toModel(availableRaffle, raffles, availableRaffles);

        availableRaffleRepository.save(availableRaffleModel);
    }
}
