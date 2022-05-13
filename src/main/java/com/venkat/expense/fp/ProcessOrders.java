package com.venkat.expense.fp;

import com.venkat.expense.fp.model.Item;
import com.venkat.expense.fp.model.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessOrders {

    private static List<Order> findAll(){

        Item item1 = new Item(1, "Laptop",1, new BigDecimal("3120.45"));
        Item item2 = new Item(2, "Mouse",1, new BigDecimal("20.45"));
        Item item3 = new Item(3, "Ear Phone",1, new BigDecimal("320.45"));
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        BigDecimal sumOfOrders = items.stream()
                .map(item -> item.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        Order order = new Order(1, Arrays.asList(item1, item2, item3), sumOfOrders);

        item1 = new Item(4, "Monitor",1, new BigDecimal("120.45"));
        item2 = new Item(5, "Mouse",1, new BigDecimal("20.45"));
        item3 = new Item(6, "CPU",1, new BigDecimal("720.45"));
        items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        sumOfOrders = items.stream()
                .map(item -> item.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        Order order2 = new Order(2, Arrays.asList(item1, item2, item3), sumOfOrders);

        item1 = new Item(7, "iPhone",1, new BigDecimal("1020.45"));
        item2 = new Item(8, "Ear buds",1, new BigDecimal("340.45"));
        items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        sumOfOrders = items.stream()
                .map(item -> item.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        Order order3 = new Order(3, Arrays.asList(item1, item2), sumOfOrders);

        return Arrays.asList(order, order2, order3);
    }

    public static void main(String[] args) {
        List<Order> orders = findAll();

        BigDecimal sumOfItems = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .map(item -> item.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal :: add);

        System.out.println("Sum of items " + sumOfItems);

        BigDecimal sumOfOrders = orders.stream()
                .map(order -> order.getTotalAmount())
                .reduce(BigDecimal.ZERO, BigDecimal :: add);

        System.out.println("Sum of orders " + sumOfOrders);
    }
}
