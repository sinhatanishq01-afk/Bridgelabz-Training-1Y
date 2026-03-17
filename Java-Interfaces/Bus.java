package com.gla.interface_abstraction;

public class Bus implements RentalVehicle {
    public void rent() {
        System.out.println("Bus rented");
    }
    public void returnVehicle() {
        System.out.println("Bus returned");
    }
}