package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.adapter.service.feign.ImageClient;
import dev.fredyhg.raffleluteranosddd.application.properties.ImgurProperties;
import dev.fredyhg.raffleluteranosddd.common.dto.ImageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImgurImageUploadService implements ImageUploadService {

    private static final String TYPE = "base64";

    private final ImageClient imageClient;

    private final ImgurProperties imgurProperties;

    @Override
    public ImageResponse uploadImage(String imageBase64, String title) {
        return imageClient.uploadImage("Client-ID " + imgurProperties.getClientId(), TYPE, imageBase64, title);
    }
}
