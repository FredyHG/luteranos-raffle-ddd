package dev.fredyhg.raffleluteranosddd.domain.models.admin;

import dev.fredyhg.raffleluteranosddd.domain.ports.AdminPersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.RequestAdminReceiverPort;

public class RequestAdminReceiverPortImpl implements RequestAdminReceiverPort {

    private final AdminPersistPort adminPersistPort;

    public RequestAdminReceiverPortImpl(AdminPersistPort adminPersistPort) {
        this.adminPersistPort = adminPersistPort;
    }

    @Override
    public Admin save(Admin admin) {
        return adminPersistPort.save(admin);
    }
}
