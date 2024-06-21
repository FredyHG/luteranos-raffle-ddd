package dev.fredyhg.raffleluteranosddd.factory;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleCollectionModel;
import org.instancio.Instancio;
import org.instancio.Model;

import java.util.Collections;
import java.util.UUID;

import static org.instancio.Select.field;

public class RaffleCollectionModelFactory {
    private static final Model<RaffleCollectionModel> RAFFLE_COLLECTION_MODEL =
            Instancio.of(RaffleCollectionModel.class)
                    .set(field(RaffleCollectionModel::getId), UUID.randomUUID().toString())
                    .set(field(RaffleCollectionModel::getAvailable), Collections.emptyList())
                    .toModel();

    public static RaffleCollectionModel withValidName(String name) {
        return Instancio.of(RAFFLE_COLLECTION_MODEL)
                .set(field(RaffleCollectionModel::getCollectionName), name)
                .create();
    }

    public static RaffleCollectionModel withEmptyRaffles(String name) {
        return Instancio.of(RAFFLE_COLLECTION_MODEL)
                .set(field(RaffleCollectionModel::getCollectionName), name)
                .set(field(RaffleCollectionModel::getRaffles), Collections.emptyList())
                .create();
    }

}
