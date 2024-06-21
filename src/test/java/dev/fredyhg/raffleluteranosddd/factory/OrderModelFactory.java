package dev.fredyhg.raffleluteranosddd.factory;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.OrderModel;
import org.instancio.Instancio;
import org.instancio.Model;

public class OrderModelFactory {
    private static final Model<OrderModel> ORDER_MODEL_MODEL =
            Instancio.of(OrderModel.class)
                    .toModel();

    public static OrderModel valid() {
        return Instancio.of(ORDER_MODEL_MODEL)
                .create();
    }
}
