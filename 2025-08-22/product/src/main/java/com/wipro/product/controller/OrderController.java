package com.wipro.product.controller;

import com.wipro.product.entity.Order;
import com.wipro.product.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place/{productId}")
    public Order placeOrder(@PathVariable Long productId, @RequestParam int qty) {
        return orderService.placeOrder(productId, qty);
    }

    @GetMapping("/history")
    public List<Order> getOrderHistory() {
        return orderService.getOrderHistory();
    }
}
