package dev.fredyhg.raffleluteranosddd.common.mapper;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleCollectionModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection.RaffleCollection;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.RaffleCollectionPostRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.RaffleCollectionGetRequest;

import java.util.List;

public class RaffleCollectionMapper {

    public static RaffleCollection toRaffleCollection(RaffleCollectionPostRequest raffleCollectionPostRequest, List<Raffle> raffles) {

        return new RaffleCollection(raffleCollectionPostRequest.getRaffleType(), raffles);
    }

    public static RaffleCollectionModel toModel(RaffleCollection raffleCollection, List<RaffleModel> raffles, List<RaffleModel> availableRaffles) {
        return new RaffleCollectionModel(
                raffleCollection.getId().fromValue(),
                raffleCollection.getQntRaffle(),
                raffleCollection.getCreatedAt(),
                raffles,
                raffleCollection.getRaffleType(),
                raffleCollection.getStatus(),
                availableRaffles
        );
    }

    public static RaffleCollectionGetRequest toResponse(RaffleCollectionModel raffleCollection) {
        return new RaffleCollectionGetRequest(
                raffleCollection.getId(),
                raffleCollection.getCreatedAt(),
                raffleCollection.getStatus().toString(),
                raffleCollection.getRaffleType(),
                raffleCollection.getQntRaffle(),
                raffleCollection.getAvailable()
        );
    }


}
