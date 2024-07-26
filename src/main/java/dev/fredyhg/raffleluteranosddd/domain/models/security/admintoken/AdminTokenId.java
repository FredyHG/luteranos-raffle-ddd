package dev.fredyhg.raffleluteranosddd.domain.models.security.admintoken;

import dev.fredyhg.raffleluteranosddd.common.domain.Identifier;

import java.util.UUID;

public class AdminTokenId extends Identifier<UUID> {
    protected AdminTokenId() {
        super(UUID.randomUUID());
    }

    protected AdminTokenId(String id) {
        super(UUID.fromString(id));
    }
}
