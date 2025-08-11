package com.example.payment_service.controller;

import com.example.payment_service.entity.Payment;
import com.example.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment processPayment(@RequestBody Payment payment) {
        payment.setPaymentStatus(true);
        return paymentService.savePayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment getPaymentByOrderId(@PathVariable int orderId) {
        return paymentService.getPaymentByOrderId(orderId);
    }
}
