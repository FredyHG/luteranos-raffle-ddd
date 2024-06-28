package dev.fredyhg.raffleluteranosddd.infrastructure.http.controller;

import dev.fredyhg.raffleluteranosddd.application.usecase.CreateOrderUseCase;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.OrderPostRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.ResponseMessage;
import jakarta.validation.Valid;
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
@RequestMapping("api/v1/order")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> createOrder(@RequestBody @Valid OrderPostRequest orderPostRequest) {

        log.info("Create order with {} raffles", orderPostRequest.getRafflesIds().size());

        createOrderUseCase.createOrder(orderPostRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseMessage.builder()
                .status(201)
                .message("Order created successfully")
                .timestamp(LocalDateTime.now())
                .build());
    }

}
