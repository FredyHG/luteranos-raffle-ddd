package dev.fredyhg.raffleluteranosddd.application.config;

import dev.fredyhg.raffleluteranosddd.domain.models.RequestOrderReceiverPortImpl;
import dev.fredyhg.raffleluteranosddd.domain.models.availableraffle.RequestAvailableRaffleReceiverPortImpl;
import dev.fredyhg.raffleluteranosddd.domain.models.buyer.BuyerDtoReceiverPortImpl;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.RequestRaffleReceiverPortImpl;
import dev.fredyhg.raffleluteranosddd.domain.ports.AvailableRafflePersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.BuyerPersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.OrderPersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.RafflePersistPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public RequestRaffleReceiverPortImpl receiveRequestRafflePortImpl(RafflePersistPort rafflePersistPort) {
        return new RequestRaffleReceiverPortImpl(rafflePersistPort);
    }

    @Bean
    public RequestAvailableRaffleReceiverPortImpl receiveRequestAvailableRafflePortImpl(AvailableRafflePersistPort availableRafflePersistPort) {
        return new RequestAvailableRaffleReceiverPortImpl(availableRafflePersistPort);
    }

    @Bean
    public BuyerDtoReceiverPortImpl receiveBuyerDtoPortImpl(BuyerPersistPort buyerPersistPort) {
        return new BuyerDtoReceiverPortImpl(buyerPersistPort);
    }

    @Bean
    public RequestOrderReceiverPortImpl requestOrderReceiverPort(OrderPersistPort orderPersistPort) {
        return new RequestOrderReceiverPortImpl(orderPersistPort);
    }

}
