package dev.fredyhg.raffleluteranosddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RaffleLuteranosDddApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaffleLuteranosDddApplication.class, args);
    }

}
