package com.venkat.expense.fp.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private int id;
    private List<Item> items;
    private BigDecimal totalAmount;

    public Order(){}

    public Order(int id, List<Item> items, BigDecimal totalAmount) {
        this.id = id;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }


}
