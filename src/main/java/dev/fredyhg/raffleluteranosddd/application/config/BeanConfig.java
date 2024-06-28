package dev.fredyhg.raffleluteranosddd.application.config;

import dev.fredyhg.raffleluteranosddd.domain.models.RequestOrderReceiverPortImpl;
import dev.fredyhg.raffleluteranosddd.domain.models.buyer.BuyerDtoReceiverPortImpl;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.RequestRaffleReceiverPortImpl;
import dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection.RaffleCollectionGenWinnerPortImpl;
import dev.fredyhg.raffleluteranosddd.domain.models.rafflecollection.RaffleCollectionReceiverPortImpl;
import dev.fredyhg.raffleluteranosddd.domain.ports.*;
import dev.fredyhg.raffleluteranosddd.domain.service.ImageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public RequestRaffleReceiverPortImpl receiveRequestRafflePortImpl(RafflePersistPort rafflePersistPort, ImageService imageService) {
        return new RequestRaffleReceiverPortImpl(rafflePersistPort, imageService);
    }

    @Bean
    public RaffleCollectionReceiverPortImpl raffleCollectionReceiverPortImpl(RaffleCollectionPersistPort raffleCollectionPersistPort) {
        return new RaffleCollectionReceiverPortImpl(raffleCollectionPersistPort);
    }

    @Bean
    public BuyerDtoReceiverPortImpl receiveBuyerDtoPortImpl(BuyerPersistPort buyerPersistPort) {
        return new BuyerDtoReceiverPortImpl(buyerPersistPort);
    }

    @Bean
    public RequestOrderReceiverPortImpl requestOrderReceiverPort(OrderPersistPort orderPersistPort) {
        return new RequestOrderReceiverPortImpl(orderPersistPort);
    }

    @Bean
    public RaffleCollectionGenWinnerPortImpl RaffleCollectionGenWinnerPort(RaffleCollectionWithWinnerPersistPort raffleCollectionWithWinnerPersistPort) {
        return new RaffleCollectionGenWinnerPortImpl(raffleCollectionWithWinnerPersistPort);
    }


}
