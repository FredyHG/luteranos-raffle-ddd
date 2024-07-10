package dev.fredyhg.raffleluteranosddd.infrastructure.security.repository;

import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminModel, String> {
    Optional<AdminModel> findByUsername(String username);
}
