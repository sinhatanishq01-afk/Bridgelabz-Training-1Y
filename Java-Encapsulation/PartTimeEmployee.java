package com.gla.encapsulation;

public class PartTimeEmployee extends Employee {
    private int hoursWorked;

    public PartTimeEmployee(int id, String name, double rate, int hours) {
        super(id, name, rate);
        this.hoursWorked = hours;
    }

    public double calculateSalary() {
        return baseSalary * hoursWorked;
    }
}