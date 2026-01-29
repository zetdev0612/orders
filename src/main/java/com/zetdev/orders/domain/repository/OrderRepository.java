package com.zetdev.orders.domain.repository;

import com.zetdev.orders.domain.model.Order;

import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida (Output Port)
 * Define cómo el dominio se comunica con el mundo exterior
 */
public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(UUID id);

}
