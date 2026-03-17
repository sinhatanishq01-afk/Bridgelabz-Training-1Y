package com.gla.interface_abstraction;

public class MainApp {
    public static void main(String[] args) {

        SmartDevice device = new Light();
        device.turnOn();

        RentalVehicle car = new Car();
        car.rent();

        Payment pay = new UPI();
        pay.pay(500);

        System.out.println(SecurityUtils.isStrongPassword("java12345"));
    }
}