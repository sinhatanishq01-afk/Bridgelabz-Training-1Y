package com.gla.interface_abstraction;

public class Light implements SmartDevice {
    public void turnOn() {
        System.out.println("Light ON");
    }
    public void turnOff() {
        System.out.println("Light OFF");
    }
}