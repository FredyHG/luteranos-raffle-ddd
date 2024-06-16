package dev.fredyhg.raffleluteranosddd.usecase;

import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.ReceiveRequestRafflePortImpl;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.RafflePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveRaffleUseCase {

    private final ReceiveRequestRafflePortImpl receiveRequestRafflePortImpl;

    public void save(RafflePostRequest request) {
        Raffle raffle = RaffleMapper.toRaffle(request);
        receiveRequestRafflePortImpl.save(raffle);
    }
}
