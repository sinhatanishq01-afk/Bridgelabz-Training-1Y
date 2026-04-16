package com.gla.Generics;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> inventory = new HashMap<>();

        inventory.put("Laptop", 10);
        inventory.put("Mobile", 5);
        inventory.put("Headphones", 2);

        buyProduct(inventory, "Laptop", 3);
        buyProduct(inventory, "Headphones", 2);

        restockProduct(inventory, "Mobile", 5);
        restockProduct(inventory, "Tablet", 4);

        queryProduct(inventory, "Laptop");
        queryProduct(inventory, "Camera");

        System.out.println("\nOut of Stock Products:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void buyProduct(Map<String, Integer> inventory, String product, int qty) {
        if (inventory.containsKey(product)) {
            int current = inventory.get(product) - qty;
            inventory.put(product, Math.max(current, 0));
        }
    }

    public static void restockProduct(Map<String, Integer> inventory, String product, int qty) {
        inventory.put(product, inventory.getOrDefault(product, 0) + qty);
    }

    public static void queryProduct(Map<String, Integer> inventory, String product) {
        if (inventory.containsKey(product)) {
            System.out.println(product + " stock: " + inventory.get(product));
        } else {
            System.out.println(product + " not stocked");
        }
    }
}