package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminModel;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminTokenModel;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.repository.AdminTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RevokeAllAdminTokensUseCase {

    private final AdminTokenRepository adminTokenRepository;

    public void revoke(AdminModel adminModel) {
        List<AdminTokenModel> validAdminTokens = adminTokenRepository.findAllValidTokenByAdmin(adminModel.getId());

        if(validAdminTokens.isEmpty()) return;

        validAdminTokens.forEach(token -> {
            token.setRevoked(true);
            token.setExpired(true);
        });

        adminTokenRepository.saveAll(validAdminTokens);
    }

}
