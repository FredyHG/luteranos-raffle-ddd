package dev.fredyhg.raffleluteranosddd.factory;

import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.OrderPostRequest;
import org.instancio.Instancio;
import org.instancio.Model;

public class OrderPostRequestFactory {
    private static final Model<OrderPostRequest> ORDER_MODEL_MODEL =
            Instancio.of(OrderPostRequest.class)
                    .toModel();

    public static OrderPostRequest valid() {
        return Instancio.of(ORDER_MODEL_MODEL)
                .create();
    }
}
