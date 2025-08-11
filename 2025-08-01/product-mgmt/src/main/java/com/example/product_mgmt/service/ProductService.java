package com.example.product_mgmt.service;

import com.example.product_mgmt.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Integer id);
    void deleteProduct(Integer id);
    Product updateProduct(Integer id, Product updatedProduct);
    List<Product> getProductsByBrand(String brand);  
}
