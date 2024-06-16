package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.domain.ports.RafflePersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RafflePersistPortImpl implements RafflePersistPort {

    private final RaffleRepository raffleRepository;

    private final ImageUploadService imageUploadService;

    @Override
    public void save(Raffle raffle) {
        String urlImage = imageUploadService.uploadImage(raffle.getImageBase64());
        RaffleModel raffleModel = RaffleMapper.toRaffleModel(raffle, urlImage);

        System.out.println(raffleModel);

        raffleRepository.save(raffleModel);
    }
}
