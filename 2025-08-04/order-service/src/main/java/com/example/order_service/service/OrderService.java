package com.example.order_service.service;

import com.example.order_service.dto.OrderResponse;
import com.example.order_service.dto.Payment;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public OrderResponse getOrderWithPayments(Long orderId) {
        // Fetch the order
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Fetch payment details from Payment Service
        ResponseEntity<List<Payment>> response = restTemplate.exchange(
                "http://localhost:9011/payments/order/" + orderId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Payment>>() {
                });

        // Map order + payments into response DTO
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setProductName(order.getProductName());
        orderResponse.setQuantity(order.getQuantity());
        orderResponse.setPrice(order.getPrice());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setPaymentDetails(response.getBody()); // ✅ set payment list

        return orderResponse;
    }
}
