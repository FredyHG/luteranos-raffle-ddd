package dev.fredyhg.raffleluteranosddd.infrastructure.http.request;

import dev.fredyhg.raffleluteranosddd.common.dto.BuyerDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderPostRequest {
    @NotBlank(message = "Collection id wasn't informed")
    private String collectionId;
    @NotEmpty(message = "Raffles id cannot be empty")
    private List<String> rafflesIds;
    @NotNull(message = "Buyer id cannot be null")
    private BuyerDto buyer;
}
