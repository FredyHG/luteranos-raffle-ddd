package dev.fredyhg.raffleluteranosddd.domain.models.buyer;

import dev.fredyhg.raffleluteranosddd.common.domain.Identifier;

import java.util.UUID;

public class BuyerId extends Identifier<UUID> {
    protected BuyerId() {
        super(UUID.randomUUID());
    }
}
