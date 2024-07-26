package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.common.mapper.AdminMapper;
import dev.fredyhg.raffleluteranosddd.common.mapper.AdminTokenMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.admin.Admin;
import dev.fredyhg.raffleluteranosddd.domain.models.security.admintoken.AdminToken;
import dev.fredyhg.raffleluteranosddd.domain.ports.AdminTokenPersistPort;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveAdminTokenUseCase {

    private final AdminTokenPersistPort adminTokenPersistPort;

    public void saveToken(AdminModel adminModel, String token) {

        Admin admin = AdminMapper.modelToAdmin(adminModel);

        AdminToken adminToken = new AdminToken(token, admin);

        adminTokenPersistPort.save(adminToken);
    }
}
