package dev.fredyhg.raffleluteranosddd.adapter.persistence.repository;


import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.AvailableRaffleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableRaffleRepository extends JpaRepository<AvailableRaffleModel, String> {
}
