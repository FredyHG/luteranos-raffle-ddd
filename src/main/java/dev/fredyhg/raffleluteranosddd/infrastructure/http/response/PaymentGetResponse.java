package dev.fredyhg.raffleluteranosddd.infrastructure.http.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PaymentGetResponse {
    private String status;
    @JsonProperty("external_reference")
    private String externalReference;
}
