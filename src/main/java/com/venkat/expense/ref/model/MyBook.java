package com.venkat.expense.ref.model;

public class MyBook {

    private String title;
    private String author;
    private double price;

    public MyBook(){
        this.title = "Geetha";
        this.author = "Sri Krishna";
        this.price = 500.00d;
    }

    public MyBook(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void process(){
        System.out.println("Processing...");
    }

    private void m1(){
        System.out.println("Private method...");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MyBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
