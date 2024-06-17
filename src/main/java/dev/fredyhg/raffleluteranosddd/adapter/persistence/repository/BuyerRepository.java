package dev.fredyhg.raffleluteranosddd.adapter.persistence.repository;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerRepository extends JpaRepository<BuyerModel, String> {

    Optional<BuyerModel> findByCpf(String cpf);

}
