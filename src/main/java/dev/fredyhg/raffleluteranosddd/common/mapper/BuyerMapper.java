package dev.fredyhg.raffleluteranosddd.common.mapper;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
import dev.fredyhg.raffleluteranosddd.common.dto.BuyerDto;
import dev.fredyhg.raffleluteranosddd.domain.models.buyer.Buyer;

public class BuyerMapper {

    public static Buyer toBuyer(BuyerDto buyerDto) {
        return new Buyer(buyerDto.getName(), buyerDto.getEmail(), buyerDto.getCpf());
    }

    public static BuyerModel toModel(Buyer buyer) {
        return new BuyerModel(buyer.getId().fromValue(), buyer.getEmail(), buyer.getName(), buyer.getCpf());
    }

    public static Buyer modelToMapper(BuyerModel buyerModel) {
        return new Buyer(buyerModel.getId(),
                buyerModel.getName(),
                buyerModel.getEmail(),
                buyerModel.getCpf());
    }
}
