package dev.fredyhg.raffleluteranosddd.infrastructure.http.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BuyRaffleResponse {
    private String buyerName;
    private String qrCodeBase64;
    private String pixPaymentLink;
}
