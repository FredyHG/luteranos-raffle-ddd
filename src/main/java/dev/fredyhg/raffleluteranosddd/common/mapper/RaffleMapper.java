package dev.fredyhg.raffleluteranosddd.common.mapper;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.RafflePostRequest;

public class RaffleMapper {
    public static Raffle toRaffle(RafflePostRequest raffle) {
        return new Raffle(raffle.getName(), raffle.getBase64Image(), raffle.getPrice());
    }

    public static RaffleModel toRaffleModel(Raffle raffle, String imageUrl) {
        return new RaffleModel(raffle.getId().fromValue(),
                raffle.getName(),
                imageUrl,
                raffle.getPrice());
    }
}
