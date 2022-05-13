package com.venkat.expense.fp.model;

import java.math.BigDecimal;

public class Item {

    private int id;
    private String itemName;
    private int quantity;
    private BigDecimal price;

    public Item(){}

    public Item(int id, String itemName, int quantity, BigDecimal price) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
