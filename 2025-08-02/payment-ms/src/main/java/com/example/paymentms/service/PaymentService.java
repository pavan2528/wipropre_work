package com.example.paymentms.service;

import com.example.paymentms.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment savePayment(Payment payment);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
    Payment updatePayment(Long id, Payment payment);
    void deletePayment(Long id);
}
