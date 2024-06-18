package dev.fredyhg.raffleluteranosddd.domain.models.raffle;

import dev.fredyhg.raffleluteranosddd.common.domain.Identifier;

import java.util.UUID;

public class RaffleId extends Identifier<UUID> {
    protected RaffleId() {
        super(UUID.randomUUID());
    }

    public RaffleId(String id) {
        super(UUID.fromString(id));
    }

}
