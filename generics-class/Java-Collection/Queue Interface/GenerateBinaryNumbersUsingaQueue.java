package com.gla.Generics;

import java.util.*;

public class Main {

    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 1; i <= n; i++) {
            String current = queue.peek();
            result.add(current);

            queue.add(current + "0");
            queue.add(current + "1");

            queue.remove();
        }

        return result;
    }

    public static void main(String[] args) {

        int n = 5;
        System.out.println(generateBinary(n));
    }
}