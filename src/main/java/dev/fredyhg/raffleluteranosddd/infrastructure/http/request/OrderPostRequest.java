package dev.fredyhg.raffleluteranosddd.infrastructure.http.request;

import dev.fredyhg.raffleluteranosddd.common.dto.BuyerDto;
import lombok.Data;

import java.util.List;

@Data
public class OrderPostRequest {

    private List<String> rafflesIds;

    private BuyerDto buyer;
}
