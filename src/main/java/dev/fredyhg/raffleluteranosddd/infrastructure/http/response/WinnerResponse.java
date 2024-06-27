package dev.fredyhg.raffleluteranosddd.infrastructure.http.response;

import dev.fredyhg.raffleluteranosddd.common.dto.BuyerDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WinnerResponse {
    private String orderId;
    private BuyerDto buyer;
}
