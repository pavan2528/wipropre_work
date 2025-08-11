package com.example.orderservice.controller;

import com.example.orderservice.client.PaymentClient;
import com.example.orderservice.model.Order;
import com.example.orderservice.dto.PaymentDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final PaymentClient paymentClient;

    public OrderController(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = "orderService", fallbackMethod = "orderFallback")
    public Map<String, Object> getOrderWithPayment(@PathVariable Long id) {
        // sample fixed orders
        Order order = switch (id.intValue()) {
            case 1 -> new Order(1L, "Phone", 300.0);
            case 2 -> new Order(2L, "Laptop", 1200.0);
            default -> new Order(id, "Unknown", 0.0);
        };

        PaymentDto payment = paymentClient.getPaymentByOrderId(id);
        return Map.of("order", order, "payment", payment);
    }

    public Map<String, Object> orderFallback(Long id, Throwable t) {
        Order order = new Order(id, "Unknown", 0.0);
        return Map.of("order", order, "payment", Map.of("status", "PAYMENT_SERVICE_DOWN"));
    }
}
