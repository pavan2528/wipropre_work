package com.example.orderservice.client;

import com.example.orderservice.dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "payment-service", url = "${payment.service.url}")
public interface PaymentClient {
    @GetMapping("/payments/order/{orderId}")
    PaymentDto getPaymentByOrderId(@PathVariable("orderId") Long orderId);
}
