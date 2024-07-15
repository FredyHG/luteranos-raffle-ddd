package dev.fredyhg.raffleluteranosddd.infrastructure.http.controller;

import dev.fredyhg.raffleluteranosddd.application.usecase.SaveAdminUseCase;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.AdminPostRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.ResponseMessage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final SaveAdminUseCase saveAdminUseCase;

    @PostMapping
    public ResponseEntity<ResponseMessage> createAdmin(@RequestBody @Valid AdminPostRequest adminToSave) {

        saveAdminUseCase.createAdmin(adminToSave);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ResponseMessage
                        .builder()
                        .message("Admin created successfully")
                        .build()
        );
    }
}
