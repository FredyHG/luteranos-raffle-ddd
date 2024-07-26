package dev.fredyhg.raffleluteranosddd.infrastructure.http.controller;

import dev.fredyhg.raffleluteranosddd.application.usecase.SaveAdminUseCase;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.AdminPostRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.ResponseMessage;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final SaveAdminUseCase saveAdminUseCase;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> createAdmin(@RequestBody @Valid AdminPostRequest adminToSave) {

        saveAdminUseCase.createAdmin(adminToSave);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ResponseMessage
                        .builder()
                        .message("Admin created successfully")
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.CREATED.value())
                        .build()
        );
    }
}
