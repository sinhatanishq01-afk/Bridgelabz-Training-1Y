package com.gla.Generics;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> attendance = new HashMap<>();

        List<String> students = Arrays.asList("Aman", "Riya", "Rahul", "Neha", "Simran");

        for (String s : students) {
            attendance.put(s, 0);
        }

        List<List<String>> monthAttendance = Arrays.asList(
                Arrays.asList("Aman", "Riya", "Rahul"),
                Arrays.asList("Aman", "Neha"),
                Arrays.asList("Riya", "Simran"),
                Arrays.asList("Aman", "Rahul", "Simran"),
                Arrays.asList("Neha", "Riya"),
                Arrays.asList("Aman", "Riya", "Simran"),
                Arrays.asList("Rahul", "Neha"),
                Arrays.asList("Aman", "Simran"),
                Arrays.asList("Riya", "Rahul"),
                Arrays.asList("Aman", "Neha", "Simran"),
                Arrays.asList("Riya", "Simran"),
                Arrays.asList("Aman", "Rahul"),
                Arrays.asList("Neha", "Simran"),
                Arrays.asList("Aman", "Riya"),
                Arrays.asList("Rahul", "Simran")
        );

        for (List<String> day : monthAttendance) {
            for (String student : day) {
                attendance.put(student, attendance.get(student) + 1);
            }
        }

        int threshold = 10;

        System.out.println("Under-attending students:");
        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            if (entry.getValue() < threshold) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}