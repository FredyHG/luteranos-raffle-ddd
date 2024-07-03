package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.OrderModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.model.RaffleModel;
import dev.fredyhg.raffleluteranosddd.adapter.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentSuccessUseCase {

    private final OrderRepository orderRepository;

    public void savePaymentSuccess(OrderModel orderModel) {

        List<RaffleModel> raffles = orderModel.getRaffles().stream().map(RaffleModel::toggleSold).toList();


    }

}
