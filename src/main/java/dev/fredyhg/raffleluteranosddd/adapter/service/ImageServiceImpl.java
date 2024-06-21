package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.common.dto.ImageResponse;
import dev.fredyhg.raffleluteranosddd.domain.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImgurImageUploadService imgurImageUploadService;

    @Override
    public ImageResponse uploadImage(String imageBase64, String title) {
        return imgurImageUploadService.uploadImage(imageBase64, title);
    }
}
