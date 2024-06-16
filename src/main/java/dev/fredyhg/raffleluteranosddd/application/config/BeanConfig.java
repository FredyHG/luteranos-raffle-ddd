package dev.fredyhg.raffleluteranosddd.application.config;

import dev.fredyhg.raffleluteranosddd.domain.models.availableraffle.ReceiveRequestAvailableRafflePortImpl;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.ReceiveRequestRafflePortImpl;
import dev.fredyhg.raffleluteranosddd.domain.ports.AvailableRafflePersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.RafflePersistPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ReceiveRequestRafflePortImpl receiveRequestRafflePortImpl(RafflePersistPort rafflePersistPort) {
        return new ReceiveRequestRafflePortImpl(rafflePersistPort);
    }

    @Bean
    public ReceiveRequestAvailableRafflePortImpl receiveRequestAvailableRafflePort(AvailableRafflePersistPort availableRafflePersistPort) {
        return new ReceiveRequestAvailableRafflePortImpl(availableRafflePersistPort);
    }

}
