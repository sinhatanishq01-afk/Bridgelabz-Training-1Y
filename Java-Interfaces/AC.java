package com.gla.interface_abstraction;

public class AC implements SmartDevice {
    public void turnOn() {
        System.out.println("AC ON");
    }
    public void turnOff() {
        System.out.println("AC OFF");
    }
}