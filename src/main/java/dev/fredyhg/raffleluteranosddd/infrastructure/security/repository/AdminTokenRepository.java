package dev.fredyhg.raffleluteranosddd.infrastructure.security.repository;

import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminTokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AdminTokenRepository extends JpaRepository<AdminTokenModel, String> {

    @Query(value = """
    select t from AdminTokenModel t inner join AdminModel u\s
    on t.admin.id = u.id \s
    where u.id = :id and (t.expired = false or t.revoked = false)
    """)
    List<AdminTokenModel> findAllValidTokenByAdmin(String id);

    Optional<AdminTokenModel> findByToken(String token);
}
