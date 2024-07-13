package dev.fredyhg.raffleluteranosddd.infrastructure.security.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.response.ResponseMessage;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.repository.AdminTokenRepository;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.service.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilterConfig extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final UserDetailsService userDetailsService;

    private final AdminTokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        

    }

    private boolean isAuthApiRequest(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/api/auth/authenticate");
    }

    private boolean extractJwt(String authHeader) {
        return authHeader == null || !authHeader.startsWith("Bearer ");
    }


    private void sendErrorResponse(HttpServletResponse response, ExpiredJwtException ex) throws IOException {

        Gson gson = new Gson();

        response.setContentType("application/json");
        response.setStatus(HttpStatus.CONFLICT.value());

        ResponseMessage errorMessage = ResponseMessage.builder()
                .message(ex.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .message("Token expired")
                .build();


        try {
            response.getWriter().write(gson.toJson(errorMessage));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
