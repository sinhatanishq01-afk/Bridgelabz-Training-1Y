package com.gla.encapsulation;

public abstract class Product {
    private int productId;
    private String name;
    protected double price;

    public Product(int id, String name, double price) {
        productId = id;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();
}