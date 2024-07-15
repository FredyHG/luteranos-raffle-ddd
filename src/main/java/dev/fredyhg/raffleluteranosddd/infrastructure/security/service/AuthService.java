package dev.fredyhg.raffleluteranosddd.infrastructure.security.service;

import dev.fredyhg.raffleluteranosddd.common.exception.AdminNotFoundException;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.AuthenticationRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.AuthenticationResponse;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminModel;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminTokenModel;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.repository.AdminRepository;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.repository.AdminTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AdminRepository adminRepository;
    private final AdminTokenRepository adminTokenRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public final AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        AdminModel admin = adminRepository.findByUsername(authenticationRequest.getEmail())
                .orElseThrow(() -> new AdminNotFoundException("Admin not found"));

        String jwtToken = jwtService.generateToken(admin);
        revokeAllAdminToken(admin);

        adminRepository.save(admin);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();

    }

    private void revokeAllAdminToken(AdminModel admin) {
        List<AdminTokenModel> validAccountTokens = adminTokenRepository.findAllValidTokenByAdmin(admin.getId());

        if(validAccountTokens.isEmpty()) return;

        validAccountTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });

        adminTokenRepository.saveAll(validAccountTokens);
    }


}
