package com.zetdev.orders.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO de entrada para crear una orden
 * Representa datos provenientes del mundo exterior (HTTP, mensajería, etc.)
 */
public class CreateOrderRequest {

    private final UUID customerId;
    private final BigDecimal totalAmount;

    public CreateOrderRequest(UUID customerId, BigDecimal totalAmount) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
