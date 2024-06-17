package dev.fredyhg.raffleluteranosddd.domain.models.buyer;

import dev.fredyhg.raffleluteranosddd.domain.ports.BuyerPersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.BuyerDtoReceiverPort;

public class BuyerDtoReceiverPortImpl implements BuyerDtoReceiverPort {

    private final BuyerPersistPort buyerPersistPort;

    public BuyerDtoReceiverPortImpl(BuyerPersistPort buyerPersistPort) {
        this.buyerPersistPort = buyerPersistPort;
    }

    @Override
    public Buyer save(Buyer buyer) {
        buyerPersistPort.save(buyer);
        return buyer;
    }
}
