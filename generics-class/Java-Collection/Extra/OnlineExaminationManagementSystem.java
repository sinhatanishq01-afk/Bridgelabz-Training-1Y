package com.gla.Generics;

import java.util.*;

class Question {
    int id;
    String text;

    Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return "Q" + id + ": " + text;
    }
}

class Student {
    String id;
    String name;

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return name + " (" + id + ")";
    }
}

public class Main {

    public static void main(String[] args) {

        List<Question> questions = new ArrayList<>();
        questions.add(new Question(1, "What is Java?"));
        questions.add(new Question(2, "Explain OOP."));
        questions.add(new Question(3, "What is JVM?"));

        Collections.shuffle(questions);

        Set<String> studentIds = new HashSet<>();
        studentIds.add("S1");
        studentIds.add("S2");
        studentIds.add("S1");

        Queue<Student> queue = new LinkedList<>();
        queue.add(new Student("S1", "Aman"));
        queue.add(new Student("S2", "Riya"));
        queue.add(new Student("S3", "Rahul"));

        while (!queue.isEmpty()) {
            Student student = queue.poll();
            System.out.println("Serving: " + student);

            Stack<Question> history = new Stack<>();

            for (Question q : questions) {
                System.out.println("Showing: " + q);
                history.push(q);
            }

            System.out.println("Navigating Back:");
            while (!history.isEmpty()) {
                System.out.println("Back to: " + history.pop());
            }

            System.out.println();
        }
    }
}