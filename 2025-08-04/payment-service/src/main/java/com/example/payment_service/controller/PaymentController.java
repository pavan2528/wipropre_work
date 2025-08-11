package com.example.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.payment_service.entity.Payment;
import com.example.payment_service.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment makePayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment getPayment(@PathVariable Long orderId) {
        return paymentService.getPaymentByOrderId(orderId);
    }
}
