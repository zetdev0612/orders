package com.zetdev.orders.infrastructure.config;

import com.zetdev.orders.application.usecase.CreateOrderUseCase;
import com.zetdev.orders.application.usecase.GetOrderByIdUseCase;
import com.zetdev.orders.application.usecase.MarkOrderAsPaidUseCase;
import com.zetdev.orders.domain.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderUseCaseConfig {

    @Bean
    public CreateOrderUseCase createOrderUseCase(OrderRepository orderRepository) {
        return new CreateOrderUseCase(orderRepository);
    }

    @Bean
    public GetOrderByIdUseCase getOrderByIdUseCase(OrderRepository orderRepository) {
        return new GetOrderByIdUseCase(orderRepository);
    }

    @Bean
    public MarkOrderAsPaidUseCase markOrderAsPaidUseCase(OrderRepository orderRepository) {
        return new MarkOrderAsPaidUseCase(orderRepository);
    }
}
