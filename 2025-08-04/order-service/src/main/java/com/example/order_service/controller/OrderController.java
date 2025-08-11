package com.example.order_service.controller;

import com.example.order_service.dto.OrderResponse;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}/with-payments")
    public ResponseEntity<OrderResponse> getOrderWithPayments(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderWithPayments(id));
    }
}
