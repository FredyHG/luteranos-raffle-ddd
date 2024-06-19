package dev.fredyhg.raffleluteranosddd.infrastructure.http.controller;

import com.google.gson.Gson;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.factory.AvailableRafflePostRequestFactory;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.RaffleCollectionPostRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@DirtiesContext
class RaffleControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RaffleRepository raffleRepository;

    private final Gson gson = new Gson();

    @Test
    public void testCreateRaffleSuccessfully() {

        RaffleCollectionPostRequest valid = AvailableRafflePostRequestFactory.withValidName("Valid");

        String json = gson.toJson(valid);

        given()
                .port(port)
                .header("Content-type", "application/json")
                .and()
                .body(json)
                .post("/api/v1/raffle")
                .then()
                .statusCode(201)
                .body("message", equalTo("Raffle created successfully"));
    }

    @Test
    public void testCreateRaffleUnsuccessfully() {

        RaffleCollectionPostRequest valid = AvailableRafflePostRequestFactory.withValidName("Valid");
        String alreadyExistName = valid.getRaffles().get(0).getName();

        RaffleModel raffleModel = new RaffleModel(UUID.randomUUID().toString(), alreadyExistName, "121", BigDecimal.ONE);

        raffleRepository.save(raffleModel);

        String json = gson.toJson(valid);

        given()
                .port(port)
                .header("Content-type", "application/json")
                .and()
                .body(json)
                .post("/api/v1/raffle")
                .then()
                .statusCode(409)
                .body("message", equalTo("Raffle with name "+ alreadyExistName +" already exists"));
    }
}