package dev.fredyhg.raffleluteranosddd.domain.ports;

import dev.fredyhg.raffleluteranosddd.domain.models.buyer.Buyer;

public interface BuyerDtoReceiverPort {
    Buyer save(Buyer buyer);
}
