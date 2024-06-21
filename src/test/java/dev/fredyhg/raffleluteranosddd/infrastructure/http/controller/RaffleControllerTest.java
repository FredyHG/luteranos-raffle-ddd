package dev.fredyhg.raffleluteranosddd.infrastructure.http.controller;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.google.gson.Gson;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.RaffleRepository;
import dev.fredyhg.raffleluteranosddd.common.dto.ImageResponse;
import dev.fredyhg.raffleluteranosddd.factory.ImageResponseFactory;
import dev.fredyhg.raffleluteranosddd.factory.RaffleCollectionPostRequestFactory;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.RaffleCollectionPostRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.UUID;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@WireMockTest(httpPort = 8181)
class RaffleControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RaffleRepository raffleRepository;

    private final Gson gson = new Gson();

    @Test
    void testCreateRaffleSuccessfully() {

        ImageResponse validResponse = ImageResponseFactory.valid();
        String imageResponse = gson.toJson(validResponse);

        WireMock.stubFor(post(urlEqualTo("/3/image"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(imageResponse)
                        .withStatus(200)));

        RaffleCollectionPostRequest valid = RaffleCollectionPostRequestFactory.withValidName("Valid");
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
    void testCreateRaffleUnsuccessfully() {

        RaffleCollectionPostRequest valid = RaffleCollectionPostRequestFactory.withValidName("Valid");
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