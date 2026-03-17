package com.gla.encapsulation;

public class MainApp {
    public static void main(String[] args) {

        Employee e1 = new FullTimeEmployee(1, "Amit", 30000);
        Employee e2 = new PartTimeEmployee(2, "Ravi", 200, 40);

        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
    }
}