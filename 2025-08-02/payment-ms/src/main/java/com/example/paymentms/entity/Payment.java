package com.example.paymentms.entity;

import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentMode; 
    private Double amount;
    private String description;

    
    public Payment() {}

  
    public Payment(Long id, String paymentMode, Double amount, String description) {
        this.id = id;
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentMode='" + paymentMode + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
