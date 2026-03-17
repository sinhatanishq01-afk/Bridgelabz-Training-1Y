package com.gla.interface_abstraction;

public class Bike implements RentalVehicle {
    public void rent() {
        System.out.println("Bike rented");
    }
    public void returnVehicle() {
        System.out.println("Bike returned");
    }
}