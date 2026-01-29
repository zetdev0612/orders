package com.zetdev.orders.application.usecase;

import com.zetdev.orders.application.dto.CreateOrderRequest;
import com.zetdev.orders.application.dto.OrderResponse;
import com.zetdev.orders.domain.model.Order;
import com.zetdev.orders.domain.repository.OrderRepository;

import java.util.Objects;

/**
 * Caso de uso: Crear Orden
 * Orquesta el flujo sin contener lógica de negocio
 */
public class CreateOrderUseCase {

    private final OrderRepository orderRepository;

    public CreateOrderUseCase(OrderRepository orderRepository) {
        this.orderRepository = Objects.requireNonNull(orderRepository);
    }

    public OrderResponse execute(CreateOrderRequest request) {
        Objects.requireNonNull(request, "CreateOrderRequest no puede ser null");

        Order order = Order.create(
                request.getCustomerId(),
                request.getTotalAmount()
        );

        Order savedOrder = orderRepository.save(order);

        return OrderResponse.from(savedOrder);
    }
}
