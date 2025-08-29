package com.wipro.paymentms.service;

import com.wipro.paymentms.model.Payment;
import com.wipro.paymentms.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "T1", groupId = "payment-group")
    public void processPayment(String message) {
      
        String[] parts = message.split(",");
        Long bookingId = Long.parseLong(parts[0].split(":")[1].trim());
        double amount = Double.parseDouble(parts[1].split(":")[1].trim());
        String method = parts[2].split(":")[1].trim();
        String cardNumber = parts[3].split(":")[1].trim();
        String cardHolderName = parts[4].split(":")[1].trim();
        String expiryDate = parts[5].split(":")[1].trim();
        String cvv = parts[6].split(":")[1].trim();

        boolean isValid = cardNumber.length() == 16 &&
                          YearMonth.parse(expiryDate, DateTimeFormatter.ofPattern("MM/yyyy")).isAfter(YearMonth.now());

        String status = isValid ? "successful" : "failed";

        Payment payment = new Payment();
        payment.setBookingId(bookingId);
        payment.setAmount(amount);
        payment.setPaymentMethod(method);
        payment.setStatus(status);
        payment.setCardNumber(cardNumber);
        payment.setCardHolderName(cardHolderName);
        payment.setExpiryDate(expiryDate);
        payment.setCvv(cvv);
        paymentRepository.save(payment);

        String response = "Booking ID: " + bookingId + ", Status: " + status;
        kafkaTemplate.send("T2", response);
    }
}