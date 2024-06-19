package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.common.dto.BuyerDto;
import dev.fredyhg.raffleluteranosddd.common.mapper.BuyerMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.buyer.Buyer;
import dev.fredyhg.raffleluteranosddd.domain.models.buyer.BuyerDtoReceiverPortImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveBuyerUseCase {

    private final BuyerDtoReceiverPortImpl buyerDtoReceiverPortImpl;

    public Buyer save(BuyerDto buyerDto) {
        Buyer buyer = BuyerMapper.toBuyer(buyerDto);

        return buyerDtoReceiverPortImpl.save(buyer);
    }

}
