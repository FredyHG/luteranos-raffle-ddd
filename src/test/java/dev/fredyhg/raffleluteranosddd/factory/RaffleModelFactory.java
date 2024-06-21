package dev.fredyhg.raffleluteranosddd.factory;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import org.instancio.Instancio;
import org.instancio.Model;

import java.util.UUID;

import static org.instancio.Select.field;

public class RaffleModelFactory {
    private static final Model<RaffleModel> VALID_RAFFLE_MODEL =
            Instancio.of(RaffleModel.class)
                    .set(field(RaffleModel::getId), UUID.randomUUID().toString())
                    .set(field(RaffleModel::getOrder), null)
                    .toModel();

    public static RaffleModel withValidName(String name) {
        return Instancio.of(VALID_RAFFLE_MODEL)
                .set(field(RaffleModel::getName), name)
                .create();
    }
}
