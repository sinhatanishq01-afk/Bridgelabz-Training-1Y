package com.gla.Generics;

import java.util.*;

public class Main {

    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String item : list) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> result = findFrequency(list);

        System.out.println(result);
    }
}