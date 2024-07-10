package dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model;

import dev.fredyhg.raffleluteranosddd.domain.enums.TokenType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class AdminTokenModel {

    @Id
    private String id;

    private String token;

    private TokenType tokenType = TokenType.BEARER;

    private boolean revoked;

    private boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private AdminModel admin;
}
