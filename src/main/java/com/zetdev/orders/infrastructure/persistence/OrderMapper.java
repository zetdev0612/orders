package com.zetdev.orders.infrastructure.persistence;

import com.zetdev.orders.domain.model.Order;

/**
 * Mapper explícito entre dominio y entidad JPA
 */
class OrderMapper {

    /** Convierte de dominio a entidad JPA */
    static OrderEntity toEntity(Order order) {
        return new OrderEntity(
                order.getId(),
                order.getCustomerId(),
                order.getTotalAmount(),
                order.getStatus(),
                order.getCreatedAt(),
                order.getPaidAt()
        );
    }

    /** Convierte de entidad JPA a dominio */
    static Order toDomain(OrderEntity entity) {
        return new Order(
                entity.getId(),
                entity.getCustomerId(),
                entity.getTotalAmount(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getPaidAt()
        );
    }

    static void updateEntity(OrderEntity entity, Order order) {
        entity.setStatus(order.getStatus());
        entity.setPaidAt(order.getPaidAt());
    }
}