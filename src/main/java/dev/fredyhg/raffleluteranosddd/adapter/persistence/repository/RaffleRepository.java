package dev.fredyhg.raffleluteranosddd.adapter.persistence.repository;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaffleRepository extends JpaRepository<RaffleModel, String> {
}
