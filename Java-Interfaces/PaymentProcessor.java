package com.gla.interface_abstraction;

public interface PaymentProcessor {
    void processPayment();

    default void refund() {
        System.out.println("Refund successful");
    }
}