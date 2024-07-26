package dev.fredyhg.raffleluteranosddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients("dev.fredyhg")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class RaffleLuteranosDddApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaffleLuteranosDddApplication.class, args);
    }

}
