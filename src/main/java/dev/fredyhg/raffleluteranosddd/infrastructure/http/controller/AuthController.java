package dev.fredyhg.raffleluteranosddd.infrastructure.http.controller;

import dev.fredyhg.raffleluteranosddd.application.usecase.AuthenticateUseCase;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.AuthenticationRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticateUseCase authenticateUseCase;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticateUseCase.authenticate(authenticationRequest));
    }
}
