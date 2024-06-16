package dev.fredyhg.raffleluteranosddd.infrastructure.http.controller;

import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.AvailableRafflePostRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.ResponseMessage;
import dev.fredyhg.raffleluteranosddd.usecase.SaveAvailableRaffleUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/raffle")
public class RaffleController {

    private final SaveAvailableRaffleUseCase saveAvailableRaffleUseCase;

    @PostMapping
    public ResponseEntity<ResponseMessage> createRaffle(@RequestBody AvailableRafflePostRequest availableRafflePostRequest) {
        log.info("Receive request to save raffle type with name: {}", availableRafflePostRequest.getRaffleType());
        log.info("Receive request to save list of raffles with size: {}", availableRafflePostRequest.getRaffles().size());

        saveAvailableRaffleUseCase.createAvailableRaffle(availableRafflePostRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseMessage.builder()
                .message("Raffle created successfully")
                .status(201)
                .timestamp(LocalDateTime.now())
                .build());
    }

}
