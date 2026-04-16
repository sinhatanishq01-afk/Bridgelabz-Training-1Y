package com.gla.Generics;

import java.util.*;

public class Main {

    public static <T> void reverseQueue(Queue<T> queue) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            T element = queue.remove();

            for (int j = 0; j < size - i - 1; j++) {
                queue.add(queue.remove());
            }

            queue.add(element);
        }
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        reverseQueue(queue);
        System.out.println(queue);
    }
}