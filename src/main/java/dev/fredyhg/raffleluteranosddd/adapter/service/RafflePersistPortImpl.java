package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.domain.ports.RafflePersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

    @Component
    @RequiredArgsConstructor
public class RafflePersistPortImpl implements RafflePersistPort {

    private final RaffleRepository raffleRepository;

    private final ImageUploadService imageUploadService;

    @Override
    public void saveAll(List<Raffle> raffles) {

        HashMap<String, String> nameUrlImage = new HashMap<>();

        for (Raffle raffle : raffles) {
            String imageUrl = imageUploadService.uploadImage(raffle.getImageBase64());
            nameUrlImage.put(raffle.getName(), imageUrl);
        }

        List<RaffleModel> listRafflesToBeSaved = raffles.stream().map(
                raffle -> RaffleMapper.toRaffleModel(raffle, nameUrlImage.get(raffle.getName()))
        ).toList();

        raffleRepository.saveAll(listRafflesToBeSaved);
    }
}
