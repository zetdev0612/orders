package com.zetdev.orders.application.usecase;

import com.zetdev.orders.application.dto.OrderResponse;
import com.zetdev.orders.domain.exception.OrderNotFoundException;
import com.zetdev.orders.domain.model.Order;
import com.zetdev.orders.domain.repository.OrderRepository;

import java.util.UUID;

public class GetOrderByIdUseCase {

    private final OrderRepository orderRepository;

    public GetOrderByIdUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse execute(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        return OrderResponse.from(order);
    }
}
