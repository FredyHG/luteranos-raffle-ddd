package dev.fredyhg.raffleluteranosddd.infrastructure.http.controller;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.RaffleCollectionPostRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.RaffleCollectionGetRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.ResponseMessage;
import dev.fredyhg.raffleluteranosddd.application.usecase.FindRaffleCollectionUseCase;
import dev.fredyhg.raffleluteranosddd.application.usecase.FindRafflesByRaffleTypeUseCase;
import dev.fredyhg.raffleluteranosddd.application.usecase.SaveRaffleCollectionUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/raffle")
public class RaffleController {

    private final SaveRaffleCollectionUseCase saveRaffleCollectionUseCase;
    private final FindRaffleCollectionUseCase findRaffleCollectionUseCase;
    private final FindRafflesByRaffleTypeUseCase findRafflesByRaffleTypeUseCase;

    @PostMapping
    public ResponseEntity<ResponseMessage> createRaffle(@RequestBody RaffleCollectionPostRequest raffleCollectionPostRequest) {
        log.info("Receive request to save raffle type with name: {}", raffleCollectionPostRequest.getRaffleType());
        log.info("Receive request to save list of raffles with size: {}", raffleCollectionPostRequest.getRaffles().size());

        saveRaffleCollectionUseCase.createRaffleCollection(raffleCollectionPostRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseMessage.builder()
                .message("Raffle created successfully")
                .status(201)
                .timestamp(LocalDateTime.now())
                .build());
    }

    @GetMapping("/{collectionName}")
    public ResponseEntity<Page<RaffleModel>> findAvailableRequest(@PathVariable String collectionName, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(findRafflesByRaffleTypeUseCase.findRafflesByCollectionName(collectionName , pageable));
    }

    @GetMapping("/raffle-collection")
    public ResponseEntity<Page<RaffleCollectionGetRequest>> findAvailableRequest(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(findRaffleCollectionUseCase.findRaffleCollection(pageable));
    }


}
