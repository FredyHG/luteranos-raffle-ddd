package dev.fredyhg.raffleluteranosddd.domain.models.security.admintoken;

import dev.fredyhg.raffleluteranosddd.common.domain.Aggregate;
import dev.fredyhg.raffleluteranosddd.domain.enums.TokenType;
import dev.fredyhg.raffleluteranosddd.domain.models.admin.Admin;
import lombok.Getter;

@Getter
public class AdminToken extends Aggregate<AdminTokenId> {

    private final String token;

    private final TokenType tokenType = TokenType.BEARER;

    private Admin admin;

    private boolean revoked;

    private boolean expired;

    public AdminToken(String token, Admin admin) {
        super(new AdminTokenId());

        this.admin = admin;
        this.token = token;
        this.revoked = false;
        this.expired = false;
    }

    public AdminToken(String id, String token, Admin admin, boolean revoked, boolean expired) {
        super(new AdminTokenId(id));
        this.admin = admin;
        this.token = token;
        this.revoked = revoked;
        this.expired = expired;
    }
}
