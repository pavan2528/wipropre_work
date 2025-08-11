package com.example.paymentms.service;

import com.example.paymentms.entity.Payment;
import com.example.paymentms.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Override
    public Payment savePayment(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {
        Payment existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setPaymentMode(payment.getPaymentMode());
            existing.setAmount(payment.getAmount());
            existing.setDescription(payment.getDescription());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deletePayment(Long id) {
        repository.deleteById(id);
    }
}
