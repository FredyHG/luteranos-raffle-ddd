package dev.fredyhg.raffleluteranosddd.adapter.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {
    String uploadImage(String base64Image);
}
