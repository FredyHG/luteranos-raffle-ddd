package dev.fredyhg.raffleluteranosddd.adapter.persistence.repository;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RaffleRepository extends JpaRepository<RaffleModel, String> {
    Optional<RaffleModel> findByName(String name);

    @Query(value = "SELECT * FROM tb_raffle r WHERE r.raffle_id = :raffleId",
            countQuery = "SELECT count(*) FROM raffles r WHERE r.raffle_id = :raffleId",
            nativeQuery = true)
    Page<RaffleModel> findByRaffleId(@Param("raffleId") String raffleId, Pageable pageable);

    @Query(value = "SELECT * FROM tb_raffle r WHERE r.raffle_id = :raffleId",
            countQuery = "SELECT count(*) FROM raffles r WHERE r.raffle_id = :raffleId",
            nativeQuery = true)
    List<RaffleModel> findByRaffleIdNonPageable(@Param("raffleId") String raffleId);
}
