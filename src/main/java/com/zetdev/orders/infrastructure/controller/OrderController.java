package com.zetdev.orders.infrastructure.controller;

import com.zetdev.orders.application.dto.CreateOrderRequest;
import com.zetdev.orders.application.dto.OrderResponse;
import com.zetdev.orders.application.usecase.CreateOrderUseCase;
import com.zetdev.orders.application.usecase.GetOrderByIdUseCase;
import com.zetdev.orders.application.usecase.MarkOrderAsPaidUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final GetOrderByIdUseCase getOrderByIdUseCase;
    private final MarkOrderAsPaidUseCase markOrderAsPaidUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase, GetOrderByIdUseCase getOrderByIdUseCase, MarkOrderAsPaidUseCase markOrderAsPaidUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.getOrderByIdUseCase = getOrderByIdUseCase;
        this.markOrderAsPaidUseCase = markOrderAsPaidUseCase;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderHttpRequest request) {
        CreateOrderRequest useCaseRequest = new CreateOrderRequest(
                request.getCustomerId(),
                request.getTotalAmount()
        );

        OrderResponse response = createOrderUseCase.execute(useCaseRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable UUID id) {
        OrderResponse response = getOrderByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/markAsPaid/{id}")
    public ResponseEntity<OrderResponse> markOrderAsPaid(@PathVariable UUID id) {
        markOrderAsPaidUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * DTO exclusivo de infraestructura (HTTP)
     */
    static class CreateOrderHttpRequest {
        private UUID customerId;
        private BigDecimal totalAmount;

        public UUID getCustomerId() {
            return customerId;
        }

        public void setCustomerId(UUID customerId) {
            this.customerId = customerId;
        }

        public BigDecimal getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
        }
    }
}
