package dev.fredyhg.raffleluteranosddd.domain.models.buyer;

import dev.fredyhg.raffleluteranosddd.common.domain.Aggregate;
import lombok.Getter;

import static dev.fredyhg.raffleluteranosddd.common.AssertionConcern.*;

@Getter
public class Buyer extends Aggregate<BuyerId> {

    private final String name;
    private final String email;
    private final String cpf;

    protected Buyer(String name, String email, String cpf) {
        super(new BuyerId());

        assertArgumentNotNull(name, "Name cannot be null");
        assertArgumentNotEmpty(name, "Name cannot be empty");
        assertArgumentMinLength(name, 3, "Name must be at least 3 characters");

        assertArgumentNotNull(name, "Email cannot be null");
        assertArgumentNotEmpty(name, "Email cannot be empty");
        assertArgumentIsEmail(email, "Invalid email format");

        assertArgumentNotEmpty(cpf, "CPF cannot be empty");
        assertArgumentNotNull(cpf, "CPF cannot be null");
        assertArgumentIsCPF(cpf, "Invalid CPF format");

        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }
}
