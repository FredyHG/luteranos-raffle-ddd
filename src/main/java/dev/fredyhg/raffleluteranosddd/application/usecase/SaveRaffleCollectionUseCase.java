package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.exception.RaffleAlreadyExistsException;
import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleCollectionMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection.RaffleCollection;
import dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection.RaffleCollectionReceiverPortImpl;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.RaffleCollectionPostRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SaveRaffleCollectionUseCase {

    private final SaveRaffleUseCase saveRaffleUseCase;
    private final RaffleCollectionReceiverPortImpl raffleCollectionReceiverPortImpl;
    private final RaffleRepository raffleRepository;

    @Transactional
    public RaffleCollection createRaffleCollection(RaffleCollectionPostRequest raffleCollectionPostRequest) {

        raffleCollectionPostRequest.getRaffles().forEach(raff -> raffleRepository.findByName(raff.getName()).ifPresent(r -> {
            throw new RaffleAlreadyExistsException("Raffle with name " + r.getName() + " already exists");
        }));

        List<Raffle> validRaffles = saveRaffleUseCase.saveAll(raffleCollectionPostRequest.getRaffles());

        RaffleCollection raffleCollection = RaffleCollectionMapper.toRaffleCollection(raffleCollectionPostRequest, validRaffles);

        return raffleCollectionReceiverPortImpl.save(raffleCollection);
    }
}
