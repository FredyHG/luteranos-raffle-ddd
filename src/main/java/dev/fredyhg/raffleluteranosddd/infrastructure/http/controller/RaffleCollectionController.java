package dev.fredyhg.raffleluteranosddd.infrastructure.http.controller;

import dev.fredyhg.raffleluteranosddd.application.usecase.FindRaffleCollectionUseCase;
import dev.fredyhg.raffleluteranosddd.application.usecase.GenRaffleCollectionWinnerUseCase;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.RaffleCollectionGetRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.WinnerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/raffle")
public class RaffleCollectionController {

    private final FindRaffleCollectionUseCase findRaffleCollectionUseCase;
    private final GenRaffleCollectionWinnerUseCase genRaffleCollectionWinnerUseCase;

    @GetMapping("/raffle-collection")
    public ResponseEntity<Page<RaffleCollectionGetRequest>> findAvailableRequest(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(findRaffleCollectionUseCase.findRaffleCollection(pageable));
    }

    @PostMapping("/gen-winner/{collectionId}")
    public ResponseEntity<WinnerResponse> getWinnerResponse(@PathVariable String collectionId) {
        return ResponseEntity.status(HttpStatus.OK).body(genRaffleCollectionWinnerUseCase.genWinner(collectionId));
    }
}
