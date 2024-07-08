package dev.fredyhg.raffleluteranosddd.domain.ports;

import dev.fredyhg.raffleluteranosddd.domain.models.admin.Admin;

public interface RequestAdminReceiverPort {
    Admin save(Admin admin);
}
