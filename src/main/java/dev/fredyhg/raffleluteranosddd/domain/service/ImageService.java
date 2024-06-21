package dev.fredyhg.raffleluteranosddd.domain.service;

import dev.fredyhg.raffleluteranosddd.common.dto.ImageResponse;

public interface ImageService {

    ImageResponse uploadImage(String imageBase64, String title);
}
