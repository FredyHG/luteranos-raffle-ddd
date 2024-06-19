package dev.fredyhg.raffleluteranosddd.infrastructure.http.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ErrorResponse {
    private Integer statusCode;
    private String message;
    private String description;
    private LocalDateTime timestamp;
}
