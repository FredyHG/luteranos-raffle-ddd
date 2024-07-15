package dev.fredyhg.raffleluteranosddd.infrastructure.http.controller;

import dev.fredyhg.raffleluteranosddd.application.usecase.SaveOrderUseCase;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.OrderPostRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.BuyRaffleResponse;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.MercadoPagoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    private final SaveOrderUseCase saveOrderUseCase;

    @PostMapping("/create")
    public ResponseEntity<BuyRaffleResponse> createOrder(@RequestBody @Valid OrderPostRequest orderPostRequest) {

        log.info("Create order with {} raffles", orderPostRequest.getRafflesIds().size());

        return ResponseEntity.status(HttpStatus.CREATED).body(saveOrderUseCase.createOrder(orderPostRequest));
    }

    @PostMapping("/payment-callback")
    public ResponseEntity<String> paymentCallBack(@RequestBody MercadoPagoResponse mercadoPagoResponse) {
        log.info("receive call back with id");

        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

}
