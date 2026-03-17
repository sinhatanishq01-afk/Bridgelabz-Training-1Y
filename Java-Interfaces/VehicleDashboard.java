package com.gla.interface_abstraction;

public interface VehicleDashboard {
    void displaySpeed();

    default void displayBattery() {
        System.out.println("Battery: 75%");
    }
}