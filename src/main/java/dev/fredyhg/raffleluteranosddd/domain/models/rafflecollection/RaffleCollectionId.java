package dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection;

import dev.fredyhg.raffleluteranosddd.common.domain.Identifier;

import java.util.UUID;

public class RaffleCollectionId extends Identifier<UUID> {
    protected RaffleCollectionId() {
        super(UUID.randomUUID());
    }
}
