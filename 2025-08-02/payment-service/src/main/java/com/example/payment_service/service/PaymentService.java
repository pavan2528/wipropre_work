package com.example.payment_service.service;

import com.example.payment_service.entity.Payment;
import com.example.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment getPaymentByOrderId(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
