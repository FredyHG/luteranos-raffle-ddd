package dev.fredyhg.raffleluteranosddd.domain.models.admin;

import dev.fredyhg.raffleluteranosddd.common.domain.Aggregate;
import dev.fredyhg.raffleluteranosddd.domain.enums.Role;
import lombok.Getter;

import static dev.fredyhg.raffleluteranosddd.common.AssertionConcern.*;

@Getter
public class Admin extends Aggregate<AdminId> {
    private final String username;
    private String password;
    private Role role;

    public Admin(String username, String password) {
        super(new AdminId());

        assertArgumentNotNull(username, "Username cannot be null");
        assertArgumentNotEmpty(username, "Username cannot be empty");
        assertArgumentMinLength(username, 3, "Username must be at least 3 characters");

        assertArgumentNotNull(password, "Password cannot be null");
        assertArgumentNotEmpty(password, "Password cannot be empty");
        assertArgumentMinLength(password, 8, "Password must be at least 8 characters");

        this.role = Role.ROLE_ADMIN;

        this.username = username;
        this.password = password;
    }

    public Admin(String id, String username, String password) {
        super(new AdminId(id));
        this.username = username;
        this.password = password;
    }
}
