package dev.fredyhg.raffleluteranosddd.domain.ports;

import dev.fredyhg.raffleluteranosddd.domain.models.security.admintoken.AdminToken;

public interface AdminTokenPersistPort {
    AdminToken save(AdminToken adminToken);
}
