package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleCollectionModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleCollectionRepository;
import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleCollectionMapper;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.RaffleCollectionGetRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindRaffleCollectionUseCase {

    private final RaffleCollectionRepository raffleRepository;

    public Page<RaffleCollectionGetRequest> findRaffleCollection(Pageable pageable) {
        Page<RaffleCollectionModel> pageOfCollection = raffleRepository.findAll(pageable);

        return pageOfCollection.map(RaffleCollectionMapper::toResponse);
    }
}
