package dev.fredyhg.raffleluteranosddd.factory;

import dev.fredyhg.raffleluteranosddd.common.dto.ImageResponse;
import org.instancio.Instancio;
import org.instancio.Model;

public class ImageResponseFactory {
    private static final Model<ImageResponse> IMAGE_RESPONSE_MODEL =
            Instancio.of(ImageResponse.class)
                    .toModel();

    public static ImageResponse valid() {
        return Instancio.of(IMAGE_RESPONSE_MODEL)
                .create();
    }
}
