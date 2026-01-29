package com.zetdev.orders.application.usecase;

import com.zetdev.orders.application.dto.OrderResponse;
import com.zetdev.orders.domain.exception.OrderNotFoundException;
import com.zetdev.orders.domain.model.Order;
import com.zetdev.orders.domain.repository.OrderRepository;

import java.util.UUID;

public class MarkOrderAsPaidUseCase {

    private final OrderRepository orderRepository;

    public MarkOrderAsPaidUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void execute(UUID orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        order.markAsPaid();
        orderRepository.save(order);
    }
}
