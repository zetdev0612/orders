package com.zetdev.orders.infrastructure.persistence;

import java.util.UUID;

/**
 * Repositorio técnico de Spring Data
 */
public interface SpringDataOrderRepository extends org.springframework.data.jpa.repository.JpaRepository<OrderEntity, UUID> {
}