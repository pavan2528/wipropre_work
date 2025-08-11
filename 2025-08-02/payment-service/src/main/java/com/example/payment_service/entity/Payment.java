package com.example.payment_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int orderId;
    private boolean paymentStatus;
    private double amount;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public boolean isPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(boolean paymentStatus) { this.paymentStatus = paymentStatus; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
