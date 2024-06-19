package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleCollectionModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleCollectionRepository;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleCollectionMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection.RaffleCollection;
import dev.fredyhg.raffleluteranosddd.domain.ports.RaffleCollectionPersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RaffleCollectionPersistPortImpl implements RaffleCollectionPersistPort {

    private final RaffleCollectionRepository raffleCollectionRepository;
    private final RaffleRepository raffleRepository;

    @Override
    public void save(RaffleCollection raffleCollection) {

        List<RaffleModel> raffles = raffleCollection.getRaffles().stream().map(raffle ->
                        raffleRepository.findById(raffle.getId().fromValue()).orElseThrow(() -> new RuntimeException("Raffle not found")))
                .toList();

        List<RaffleModel> availableRaffles = raffleCollection.getAvailableRaffles().stream().map(raffle ->
                        raffleRepository.findById(raffle.getId().fromValue()).orElseThrow(() -> new RuntimeException("Raffle not found")))
                .toList();

        RaffleCollectionModel raffleCollectionModel = RaffleCollectionMapper.toModel(raffleCollection, raffles, availableRaffles);

        raffleCollectionRepository.save(raffleCollectionModel);
    }
}
