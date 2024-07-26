package dev.fredyhg.raffleluteranosddd.infrastructure.security.service;

import dev.fredyhg.raffleluteranosddd.common.mapper.AdminMapper;
import dev.fredyhg.raffleluteranosddd.common.mapper.AdminTokenMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.admin.Admin;
import dev.fredyhg.raffleluteranosddd.domain.models.security.admintoken.AdminToken;
import dev.fredyhg.raffleluteranosddd.domain.ports.AdminTokenPersistPort;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminModel;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminTokenModel;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.repository.AdminTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdminTokenPersistPortImpl implements AdminTokenPersistPort {

    private final AdminTokenRepository adminTokenRepository;

    @Override
    public AdminToken save(AdminToken adminToken) {
        AdminModel adminModel = AdminMapper.toModel(adminToken.getAdmin());
        AdminTokenModel adminTokenModel = AdminTokenMapper.toModel(adminToken, adminModel);

        AdminTokenModel savedAdminTokenModel = adminTokenRepository.save(adminTokenModel);

        Admin admin = AdminMapper.modelToAdmin(savedAdminTokenModel.getAdmin());

        return AdminTokenMapper.modelToAdmin(savedAdminTokenModel, admin);
    }
}
