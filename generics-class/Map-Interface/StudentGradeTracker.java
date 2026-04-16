package com.gla.Generics;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Double> grades = new HashMap<>();

        grades.put("Aman", 85.5);
        grades.put("Riya", 90.0);
        grades.put("Rahul", 78.0);

        grades.put("Aman", 88.0);

        grades.remove("Rahul");

        Map<String, Double> sortedGrades = new TreeMap<>(grades);

        for (Map.Entry<String, Double> entry : sortedGrades.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}