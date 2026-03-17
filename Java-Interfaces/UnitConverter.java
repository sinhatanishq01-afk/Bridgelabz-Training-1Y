package com.gla.interface_abstraction;

public interface UnitConverter {
    static double kmToMiles(double km) {
        return km * 0.621;
    }
    static double kgToLbs(double kg) {
        return kg * 2.204;
    }
}