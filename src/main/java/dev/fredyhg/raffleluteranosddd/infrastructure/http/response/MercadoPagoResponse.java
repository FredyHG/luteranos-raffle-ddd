package dev.fredyhg.raffleluteranosddd.infrastructure.http.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MercadoPagoResponse {
    private String action;
    private MercadoPagoData data;

    @JsonProperty("external_reference")
    private String externalReference;
}
