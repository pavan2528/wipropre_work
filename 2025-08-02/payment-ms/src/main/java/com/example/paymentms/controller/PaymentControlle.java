package com.example.paymentms.controller;

import com.example.paymentms.entity.Payment;
import com.example.paymentms.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentControlle {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.savePayment(payment);
        HttpHeaders headers = new HttpHeaders();
        headers.add("created-date", LocalDate.now().toString()); 
        return new ResponseEntity<>(savedPayment, headers, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        HttpHeaders headers = new HttpHeaders();
        headers.add("search-time", LocalDateTime.now().toString());

        if (payments.isEmpty()) {
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(payments, headers, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("search-time", LocalDateTime.now().toString());

        if (payment == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .headers(headers)
                    .body("No data found");
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(headers)
                    .body(payment);
        }
    }


    
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        Payment updated = paymentService.updatePayment(id, payment);
        if (updated != null) {
            return ResponseEntity.ok("Data modified successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment not found to update");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        Payment existing = paymentService.getPaymentById(id);
        if (existing != null) {
            paymentService.deletePayment(id);
            return ResponseEntity.ok("Data deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment not found to delete");
        }
    }
}
