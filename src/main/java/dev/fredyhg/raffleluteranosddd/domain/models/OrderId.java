package dev.fredyhg.raffleluteranosddd.domain.models;

import dev.fredyhg.raffleluteranosddd.common.domain.Identifier;

import java.util.UUID;

public class OrderId extends Identifier<UUID> {
    protected OrderId() {
        super(UUID.randomUUID());
    }
}
