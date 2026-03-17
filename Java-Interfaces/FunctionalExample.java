package com.gla.interface_abstraction;

import java.util.function.*;

public class FunctionalExample {
    public static void main(String[] args) {

        Predicate<Double> tempAlert = t -> t > 40;
        System.out.println(tempAlert.test(45.0));

        Function<String, Integer> lengthCheck = s -> s.length();
        System.out.println(lengthCheck.apply("Hello Java"));

        Runnable job = () -> System.out.println("Background task running");
        new Thread(job).start();
    }
}