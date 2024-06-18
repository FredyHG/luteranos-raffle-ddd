package dev.fredyhg.raffleluteranosddd.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.AvailableRaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.AvailableRaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.mapper.AvailableRaffleMapper;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.AvailableRaffleGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAvailableRaffleUseCase {

    private final AvailableRaffleRepository raffleRepository;

    public Page<AvailableRaffleGetResponse> findAvailableRaffles(Pageable pageable) {
        Page<AvailableRaffleModel> pageOfAvailableModel = raffleRepository.findAll(pageable);

        return pageOfAvailableModel.map(AvailableRaffleMapper::toResponse);
    }
}
