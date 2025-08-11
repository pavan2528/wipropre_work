package com.example.orderservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import java.util.Map;

@FeignClient(name="payment-service", url="${payment.service.url:}") 
interface PaymentClient {
    @GetMapping("/payments/order/{orderId}")
    Map getPayment(@PathVariable("orderId") Long orderId);
}

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final PaymentClient paymentClient;

    public OrderController(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    @GetMapping("/{id}")
    public Map getOrder(@PathVariable Long id) {
        Map payment = null;
        try {
            payment = paymentClient.getPayment(id);
        } catch (Exception e) {
            payment = Map.of("status", "PAYMENT_DOWN");
        }
        Map order = Map.of("id", id, "item", "Sample", "total", 100);
        return Map.of("order", order, "payment", payment);
    }
}
