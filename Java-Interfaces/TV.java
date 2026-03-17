package com.gla.interface_abstraction;

public class TV implements SmartDevice {
    public void turnOn() {
        System.out.println("TV ON");
    }
    public void turnOff() {
        System.out.println("TV OFF");
    }
}