package com.wipro.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Integer qtyPurchased;
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
