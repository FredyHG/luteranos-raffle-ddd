package dev.fredyhg.raffleluteranosddd.factory;

import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.RaffleCollectionPostRequest;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

public class AvailableRafflePostRequestFactory {

    private static final Model<RaffleCollectionPostRequest> AVAILABLE_RAFFLE_POST_REQUEST_MODEL =
            Instancio.of(RaffleCollectionPostRequest.class)
                    .toModel();

    public static RaffleCollectionPostRequest withValidName(String name) {
        return Instancio.of(AVAILABLE_RAFFLE_POST_REQUEST_MODEL)
                .set(field(RaffleCollectionPostRequest::getRaffleType), name)
                .create();
    }

}
