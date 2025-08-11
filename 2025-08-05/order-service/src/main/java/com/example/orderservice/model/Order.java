package com.example.orderservice.model;

public class Order {
    private Long id;
    private String item;
    private Double total;

    public Order() {}
    public Order(Long id, String item, Double total) { this.id = id; this.item = item; this.total = total; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
}
