package dev.fredyhg.raffleluteranosddd.infrastructure.http.controller;

import com.google.gson.Gson;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.BuyerModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleCollectionModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.BuyerRepository;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleCollectionRepository;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.dto.BuyerDto;
import dev.fredyhg.raffleluteranosddd.factory.BuyerModelFactory;
import dev.fredyhg.raffleluteranosddd.factory.RaffleCollectionModelFactory;
import dev.fredyhg.raffleluteranosddd.factory.RaffleModelFactory;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.OrderPostRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class OrderControllerIntegrationTest {

    @Autowired
    private RaffleRepository raffleRepository;

    @Autowired
    private RaffleCollectionRepository raffleCollectionRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @LocalServerPort
    private int port;

    private final Gson gson = new Gson();

    @Test
    void testCreateOrderSuccessfully() {

        BuyerModel savedBuyer = buyerRepository.save(BuyerModelFactory.valid());

        RaffleCollectionModel validRaffleCollection = RaffleCollectionModelFactory.withEmptyRaffles("Test");
        RaffleModel validRaffle = RaffleModelFactory.withValidName("TestName");

        RaffleModel savedRaffle = raffleRepository.save(validRaffle);

        validRaffleCollection.setRaffles(List.of(savedRaffle));

        raffleCollectionRepository.save(validRaffleCollection);

        BuyerDto buyerDto = new BuyerDto(savedBuyer.getName(), savedBuyer.getEmail(), savedBuyer.getCpf());
        OrderPostRequest orderPostRequest = new OrderPostRequest(List.of(savedRaffle.getId()), buyerDto);

        String jsonOfRequest = gson.toJson(orderPostRequest);

        given()
                .port(port)
                .header("Content-type", "application/json")
                .and()
                .body(jsonOfRequest)
                .post("api/v1/order/create")
                .then()
                .statusCode(201)
                .body("message", equalTo("Order created successfully"));
    }

}