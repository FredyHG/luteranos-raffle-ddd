package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.common.exception.AdminNotFoundException;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.AuthenticationRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.AuthenticationResponse;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminModel;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.repository.AdminRepository;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticateUseCase {

    private final JwtService jwtService;

    private final AdminRepository adminRepository;

    private final AuthenticationManager authenticationManager;

    private final RevokeAllAdminTokensUseCase revokeAllAdminTokensUseCase;

    private final SaveAdminTokenUseCase saveAdminTokenUseCase;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        AdminModel admin = adminRepository.findByUsername(
                authenticationRequest
                        .getEmail())
                .orElseThrow(() -> new AdminNotFoundException("Admin not found"));

        String jwtToken = jwtService.generateToken(admin);
        revokeAllAdminTokensUseCase.revoke(admin);

        saveAdminTokenUseCase.saveToken(admin, jwtToken);

        return AuthenticationResponse
                .builder()
                .accessToken(jwtToken)
                .build();
    }
}
