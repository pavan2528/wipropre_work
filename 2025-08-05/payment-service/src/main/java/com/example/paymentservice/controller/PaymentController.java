package com.example.paymentservice.controller;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentRepository repo;

    public PaymentController(PaymentRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/order/{orderId}")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    public ResponseEntity<?> getByOrderId(@PathVariable Long orderId) {
        return repo.findByOrderId(orderId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // simple fallback
    public ResponseEntity<?> paymentFallback(Long orderId, Throwable t) {
        return ResponseEntity.ok(Map.of(
                "orderId", orderId,
                "amount", 0,
                "status", "PAYMENT_SERVICE_DOWN"
        ));
    }
}
