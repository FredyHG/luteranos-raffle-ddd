package dev.fredyhg.raffleluteranosddd.common.mapper;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.OrderModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.domain.models.Order;
import dev.fredyhg.raffleluteranosddd.domain.models.buyer.Buyer;
import dev.fredyhg.raffleluteranosddd.domain.models.raffle.Raffle;

import java.util.List;

public class OrderMapper {

    public static Order modelToOrder(OrderModel orderModel, List<Raffle> raffles, String collectionId) {
        return new Order(collectionId, orderModel.getId(), orderModel.getTotal(), orderModel.getStatus(), orderModel.getBuyAt(), orderModel.getBuyerId(), raffles);
    }

    public static OrderModel toModel(Order order, List<RaffleModel> raffles) {
        return new OrderModel(raffles, order.getBuyerId(), order.getId().fromValue(), order.getCollectionId());
    }

    public static Order toOrder(Buyer buyer, List<Raffle> raffles, String collectionId) {
        return new Order(raffles, buyer.getId().fromValue(), collectionId);
    }

    private OrderMapper(){}
}
