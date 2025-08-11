package com.example.order_service.dto;

import java.util.List;

public class OrderResponse {

    private Long id;
    private String productName;
    private int quantity;
    private double price;
    private String status;
    private List<Payment> paymentDetails; // List instead of single payment

    // Inner DTO class for Payment details
    public static class Payment {
        private Long paymentId;
        private String paymentStatus;

        public Payment() {
        }

        public Payment(Long paymentId, String paymentStatus) {
            this.paymentId = paymentId;
            this.paymentStatus = paymentStatus;
        }

        public Long getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(Long paymentId) {
            this.paymentId = paymentId;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }
    }

    // Getters and Setters for OrderResponse fields
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
