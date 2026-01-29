package com.zetdev.orders.domain.model;

import com.zetdev.orders.domain.exception.OrderNotMarkCreatedException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


public class Order {

    private final UUID id;
    private final UUID customerId;
    private final BigDecimal totalAmount;
    private OrderStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime paidAt;

    public Order(UUID id, UUID customerId, BigDecimal totalAmount, OrderStatus status, LocalDateTime createdAt, LocalDateTime paidAt) {
        this.id = id;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = createdAt;
        this.paidAt = paidAt;
    }


    public static Order create(UUID customerId, BigDecimal totalAmount) {
        validate(customerId, totalAmount);
        return new Order(
                UUID.randomUUID(),
                customerId,
                totalAmount,
                OrderStatus.CREATED,
                LocalDateTime.now(),
                null
        );
    }

    private static void validate(UUID customerId, BigDecimal totalAmount) {
        if (customerId == null) {
            throw new IllegalArgumentException("CustomerId no puede ser null");
        }
        if (totalAmount == null || totalAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El monto total debe ser mayor o igual a cero");
        }
    }


    public void markAsPaid() {
        if (this.status == OrderStatus.PAID) {
            throw new IllegalStateException("La orden ya está pagada");
        }

        if (this.status != OrderStatus.CREATED) {
            throw new IllegalStateException(
                    "Solo se pueden pagar órdenes en estado CREATED"
            );
        }

        this.status = OrderStatus.PAID;
        this.paidAt = LocalDateTime.now();
    }

    // Getters (sin setters para mantener invariantes)
    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

