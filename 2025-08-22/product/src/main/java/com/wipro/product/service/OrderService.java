package com.wipro.product.service;

import com.wipro.product.entity.Order;
import com.wipro.product.entity.Product;
import com.wipro.product.repository.OrderRepository;
import com.wipro.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(Long productId, int qty) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQty() < qty) {
            throw new RuntimeException("Not enough stock available!");
        }

        product.setQty(product.getQty() - qty);
        productRepository.save(product);

        Order order = Order.builder()
                .product(product)
                .productName(product.getName())
                .qtyPurchased(qty)
                .orderDate(LocalDateTime.now())
                .build();

        return orderRepository.save(order);
    }

    public List<Order> getOrderHistory() {
        return orderRepository.findAll();
    }
}
