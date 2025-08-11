package com.example.order_service.dto;

import java.util.List;

public class OrderResponse {
    private Long id;
    private String productName;
    private int quantity;
    private double price;
    private String status;
    private List<Payment> paymentDetails; // ✅ Uses your Payment DTO

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Payment> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<Payment> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
