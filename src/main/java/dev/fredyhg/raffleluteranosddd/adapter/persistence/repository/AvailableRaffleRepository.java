package dev.fredyhg.raffleluteranosddd.adapter.persistence.repository;


import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.AvailableRaffleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvailableRaffleRepository extends JpaRepository<AvailableRaffleModel, String> {
    Optional<AvailableRaffleModel> findByRaffleType(String raffleType);
}
