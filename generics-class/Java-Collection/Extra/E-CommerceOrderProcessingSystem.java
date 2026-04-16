package com.gla.Generics;

import java.util.*;

class Order {
    int id;
    String item;

    Order(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public String toString() {
        return "Order{id=" + id + ", item='" + item + "'}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}

public class Main {

    public static void main(String[] args) {

        List<Order> orderList = new ArrayList<>();

        orderList.add(new Order(1, "Laptop"));
        orderList.add(new Order(2, "Mobile"));
        orderList.add(new Order(1, "Laptop"));
        orderList.add(new Order(3, "Headphones"));

        Set<Order> uniqueOrders = new HashSet<>(orderList);

        Queue<Order> queue = new LinkedList<>(uniqueOrders);

        Stack<Order> failedOrders = new Stack<>();

        while (!queue.isEmpty()) {
            Order order = queue.poll();
            System.out.println("Processing: " + order);

            if (order.id % 2 == 0) {
                System.out.println("Failed: " + order);
                failedOrders.push(order);
            } else {
                System.out.println("Success: " + order);
            }
        }

        System.out.println("\nRetrying Failed Orders:");

        while (!failedOrders.isEmpty()) {
            Order order = failedOrders.pop();
            System.out.println("Re-processing: " + order);
        }
    }
}