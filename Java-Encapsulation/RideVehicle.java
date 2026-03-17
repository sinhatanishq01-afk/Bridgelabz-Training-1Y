package com.gla.encapsulation;

public abstract class RideVehicle {
    protected String driverName;
    protected double ratePerKm;

    public RideVehicle(String driverName, double ratePerKm) {
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Driver: " + driverName);
    }
}