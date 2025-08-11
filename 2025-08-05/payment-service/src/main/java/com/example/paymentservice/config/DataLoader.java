package com.example.paymentservice.config;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner init(PaymentRepository repo) {
        return args -> {
            repo.save(new Payment(1L, 150.0, "PAID"));
            repo.save(new Payment(2L, 250.0, "PENDING"));
        };
    }
}
