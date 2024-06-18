package dev.fredyhg.raffleluteranosddd.common.mapper;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.AvailableRaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.domain.models.availableraffle.AvailableRaffle;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.AvailableRafflePostRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.AvailableRaffleGetResponse;

import java.util.List;

public class AvailableRaffleMapper {

    public static AvailableRaffle toAvailableRaffle(AvailableRafflePostRequest availableRafflePostRequest, List<Raffle> raffles) {

        return new AvailableRaffle(availableRafflePostRequest.getRaffleType(), raffles);
    }

    public static AvailableRaffleModel toModel(AvailableRaffle availableRaffle, List<RaffleModel> raffles, List<RaffleModel> availableRaffles) {
        return new AvailableRaffleModel(
                availableRaffle.getId().fromValue(),
                availableRaffle.getQntRaffle(),
                availableRaffle.getCreatedAt(),
                raffles,
                availableRaffle.getRaffleType(),
                availableRaffle.getStatus(),
                availableRaffles
        );
    }

    public static AvailableRaffleGetResponse toResponse(AvailableRaffleModel availableRaffle) {
        return new AvailableRaffleGetResponse(
                availableRaffle.getId(),
                availableRaffle.getCreatedAt(),
                availableRaffle.getStatus().toString(),
                availableRaffle.getRaffleType(),
                availableRaffle.getQntRaffle(),
                availableRaffle.getAvailable()
        );
    }


}
