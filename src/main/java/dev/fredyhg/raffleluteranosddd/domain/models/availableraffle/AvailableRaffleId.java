package dev.fredyhg.raffleluteranosddd.domain.models.availableraffle;

import dev.fredyhg.raffleluteranosddd.common.domain.Identifier;

import java.util.UUID;

public class AvailableRaffleId extends Identifier<UUID> {
    protected AvailableRaffleId() {
        super(UUID.randomUUID());
    }
}
