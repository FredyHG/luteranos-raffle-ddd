package dev.fredyhg.raffleluteranosddd.common.exception;

import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class RaffleCollectionExceptionHandler {
    private static final Map<String, HttpStatus> statusTable = new HashMap<>();


    @ExceptionHandler(RaffleCollectionException.class)
    public ResponseEntity<ErrorResponse> handleRaffleException(RaffleCollectionException ex){
        log.error("Exception handled: {}", ex.getMessage(), ex);

        HttpStatus status = mapStatus(ex);

        ErrorResponse responseMessage = ErrorResponse.builder()
                .statusCode(status.value())
                .message(ex.getMessage())
                .description(ex.getLocalizedMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(responseMessage, status);
    }

    private HttpStatus mapStatus(RaffleCollectionException ex) {
        return statusTable.getOrDefault(ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    static {

        // HTTP STATUS 404
        statusTable.put(RaffleCollectionNotFoundException.class.getSimpleName(), HttpStatus.NOT_FOUND);
    }
}
