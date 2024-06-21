package dev.fredyhg.raffleluteranosddd.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuyerDto {
    private String name;
    private String email;
    private String cpf;
}
