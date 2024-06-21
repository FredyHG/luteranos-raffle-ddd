package dev.fredyhg.raffleluteranosddd.factory;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
import org.instancio.Instancio;
import org.instancio.Model;

import java.util.UUID;

import static org.instancio.Select.field;

public class BuyerModelFactory {
    private static final Model<BuyerModel> BUYER_MODEL_MODEL =
            Instancio.of(BuyerModel.class)
                    .set(field(BuyerModel::getId), UUID.randomUUID().toString())
                    .toModel();

    public static BuyerModel valid() {
        return Instancio.of(BUYER_MODEL_MODEL)
                .create();
    }
}
