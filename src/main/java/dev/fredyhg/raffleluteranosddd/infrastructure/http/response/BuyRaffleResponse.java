package dev.fredyhg.raffleluteranosddd.infrastructure.http.response;

import dev.fredyhg.raffleluteranosddd.domain.models.Order;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BuyRaffleResponse {
    private String buyerName;
    private String qrCodeBase64;
    private String pixPaymentLink;
}
