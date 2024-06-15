package dev.fredyhg.raffleluteranosddd.application.config;

import dev.fredyhg.raffleluteranosddd.domain.models.raffle.ReceiveRequestRafflePortImpl;
import dev.fredyhg.raffleluteranosddd.domain.ports.RafflePersistPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ReceiveRequestRafflePortImpl saveRaffleService(RafflePersistPort rafflePersistPort) {
        return new ReceiveRequestRafflePortImpl(rafflePersistPort);
    }

}
