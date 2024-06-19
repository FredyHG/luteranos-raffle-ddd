package dev.fredyhg.raffleluteranosddd.adapter.persistence.repository;


import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleCollectionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaffleCollectionRepository extends JpaRepository<RaffleCollectionModel, String> {
    Optional<RaffleCollectionModel> findByRaffleType(String raffleType);
}
