package dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model;

import dev.fredyhg.raffleluteranosddd.domain.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_admin")
public class AdminModel implements UserDetails {

    @Id
    private String id;

    private String password;

    private String username;

    private Role role;

    public AdminModel(String password, String username, Role role) {
        this.password = password;
        this.username = username;
        this.role = role;
    }

    protected AdminModel(){};

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
