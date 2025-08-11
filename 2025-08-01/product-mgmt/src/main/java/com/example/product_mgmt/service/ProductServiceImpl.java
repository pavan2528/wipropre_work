package com.example.product_mgmt.service;

import com.example.product_mgmt.entity.Product;
import com.example.product_mgmt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Integer id, Product updatedProduct) {
        Optional<Product> existingProductOpt = productRepository.findById(id);
        if (existingProductOpt.isPresent()) {
            Product existing = existingProductOpt.get();
            existing.setName(updatedProduct.getName());
            existing.setModel(updatedProduct.getModel());
            existing.setDescription(updatedProduct.getDescription());
            existing.setBrand(updatedProduct.getBrand());
            existing.setPrice(updatedProduct.getPrice());
            return productRepository.save(existing);
        } else {
            return null;
        }
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }
}
