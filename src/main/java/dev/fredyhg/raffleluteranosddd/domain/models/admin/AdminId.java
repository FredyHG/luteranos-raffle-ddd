package dev.fredyhg.raffleluteranosddd.domain.models.admin;

import dev.fredyhg.raffleluteranosddd.common.domain.Identifier;

import java.util.UUID;

public class AdminId extends Identifier<UUID> {
    protected AdminId() {
        super(UUID.randomUUID());
    }

    public AdminId(String id) {
        super(UUID.fromString(id));
    }
}
