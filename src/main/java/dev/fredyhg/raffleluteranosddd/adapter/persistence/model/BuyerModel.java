package dev.fredyhg.raffleluteranosddd.adapter.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_buyer")
public class BuyerModel {
    @Id
    private String id;
    private String name;
    private String email;
    private String cpf;

    public BuyerModel(String id, String email, String name, String cpf) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.cpf = cpf;
    }

    protected BuyerModel() {}
}
