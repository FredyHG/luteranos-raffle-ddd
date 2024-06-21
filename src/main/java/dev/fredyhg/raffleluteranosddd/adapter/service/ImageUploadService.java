package dev.fredyhg.raffleluteranosddd.adapter.service;

import dev.fredyhg.raffleluteranosddd.common.dto.ImageResponse;

public interface ImageUploadService {
    ImageResponse uploadImage(String base64Image, String title);
}
