package dev.fredyhg.raffleluteranosddd.domain.models.security.admintoken;

import dev.fredyhg.raffleluteranosddd.domain.ports.AdminTokenPersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.AdminTokenReceiverPort;

public class AdminTokenReceiverPortImpl implements AdminTokenReceiverPort {

    private final AdminTokenPersistPort adminTokenPersistPort;

    public AdminTokenReceiverPortImpl(AdminTokenPersistPort adminTokenPersistPort) {
        this.adminTokenPersistPort = adminTokenPersistPort;
    }

    @Override
    public AdminToken save(AdminToken adminToken) {
        return adminTokenPersistPort.save(adminToken);
    }
}
