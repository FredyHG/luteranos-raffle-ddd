package dev.fredyhg.raffleluteranosddd.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.mapper.AvailableRaffleMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.availableraffle.AvailableRaffle;
import dev.fredyhg.raffleluteranosddd.domain.models.availableraffle.RequestAvailableRaffleReceiverPortImpl;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.AvailableRafflePostRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SaveAvailableRaffleUseCase {

    private final SaveRaffleUseCase saveRaffleUseCase;
    private final RequestAvailableRaffleReceiverPortImpl receiveRequestAvailableRafflePort;
    private final RaffleRepository raffleRepository;

    @Transactional
    public AvailableRaffle createAvailableRaffle(AvailableRafflePostRequest availableRafflePostRequest ) {

        availableRafflePostRequest.getRaffles().forEach(raff -> raffleRepository.findByName(raff.getName()).ifPresent(r -> {
            throw new RuntimeException("Raffle with name " + r.getName() + " already exists");
        }));

        List<Raffle> validRaffles = saveRaffleUseCase.saveAll(availableRafflePostRequest.getRaffles());

        AvailableRaffle availableRaffle = AvailableRaffleMapper.toAvailableRaffle(availableRafflePostRequest, validRaffles);

        return receiveRequestAvailableRafflePort.save(availableRaffle);
    }
}
