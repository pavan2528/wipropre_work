package com.example.paymentservice.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @GetMapping("/order/{orderId}")
    public Map getByOrder(@PathVariable Long orderId) {
        return Map.of("id", 1, "orderId", orderId, "amount", 150, "status", "PAID");
    }
}
