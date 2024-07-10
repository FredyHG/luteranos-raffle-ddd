package dev.fredyhg.raffleluteranosddd.domain.ports;

import dev.fredyhg.raffleluteranosddd.domain.models.admin.Admin;

public interface AdminPersistPort {
    Admin save(Admin admin);
}
