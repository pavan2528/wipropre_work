package com.example.product_mgmt.repository;

import com.example.product_mgmt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByBrand(String brand);  // Derived query method
}
