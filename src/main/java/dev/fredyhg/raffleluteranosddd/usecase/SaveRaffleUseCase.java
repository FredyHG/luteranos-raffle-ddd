package dev.fredyhg.raffleluteranosddd.usecase;

import dev.fredyhg.raffleluteranosddd.common.mapper.RaffleMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.ReceiveRequestRafflePortImpl;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.RafflePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SaveRaffleUseCase {

    private final ReceiveRequestRafflePortImpl receiveRequestRafflePortImpl;


    public List<Raffle> saveAll(List<RafflePostRequest> request) {

        List<Raffle> listOfRaffle = request
                .stream()
                .map(RaffleMapper::toRaffle)
                .toList();

        return receiveRequestRafflePortImpl.saveAll(listOfRaffle);
    }
}
