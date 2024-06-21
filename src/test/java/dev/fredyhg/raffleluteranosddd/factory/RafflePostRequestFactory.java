package dev.fredyhg.raffleluteranosddd.factory;

import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.RafflePostRequest;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

public class RafflePostRequestFactory {

    private static String base64;

    private static final Model<RafflePostRequest> VALID_RAFFLE_POST_REQUEST =
            Instancio.of(RafflePostRequest.class)
                    .toModel();

    public static RafflePostRequest withValidBase64() {
        return Instancio.of(VALID_RAFFLE_POST_REQUEST)
                .set(field(RafflePostRequest::getBase64Image), base64)
                .create();
    }
}
