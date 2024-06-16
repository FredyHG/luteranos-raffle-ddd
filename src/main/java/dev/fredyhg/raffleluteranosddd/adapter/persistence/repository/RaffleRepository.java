package dev.fredyhg.raffleluteranosddd.adapter.persistence.repository;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaffleRepository extends JpaRepository<RaffleModel, String> {
    Optional<RaffleModel> findByName(String name);
}
