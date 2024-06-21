package dev.fredyhg.raffleluteranosddd.domain.models.raffle;

import dev.fredyhg.raffleluteranosddd.domain.ports.RafflePersistPort;
import dev.fredyhg.raffleluteranosddd.domain.ports.RequestRaffleReceiverPort;
import dev.fredyhg.raffleluteranosddd.domain.service.ImageService;

import java.util.List;

public class RequestRaffleReceiverPortImpl implements RequestRaffleReceiverPort {

    private final RafflePersistPort rafflePersistPort;
    private final ImageService imageService;

    public RequestRaffleReceiverPortImpl(RafflePersistPort rafflePersistPort, ImageService imageService) {
        this.rafflePersistPort = rafflePersistPort;
        this.imageService = imageService;
    }

    @Override
    public List<Raffle> saveAll(List<Raffle> raffles) {

        List<Raffle> rafflesWithImage = raffles.stream().map(
                raffle -> raffle.setImageUrl(
                        imageService.uploadImage(raffle.getImageBase64(),
                                raffle.getName()).getData().getLink()))
                .toList();

        rafflePersistPort.saveAll(rafflesWithImage);
        return raffles;
    }
}
