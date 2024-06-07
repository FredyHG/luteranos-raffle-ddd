package dev.fredyhg.raffleluteranosddd.adapter.persistence.repository;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<BuyerModel, String> {
}
