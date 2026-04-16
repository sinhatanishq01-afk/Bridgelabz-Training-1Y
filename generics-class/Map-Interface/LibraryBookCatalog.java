package com.gla.Generics;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, String> catalog = new HashMap<>();

        catalog.put("978-1234567890", "Java Programming");
        catalog.put("978-1111111111", "Data Structures");
        catalog.put("978-2222222222", "Operating Systems");

        searchByISBN(catalog, "978-1234567890");
        searchByISBN(catalog, "978-0000000000");

        catalog.remove("978-1111111111");

        Map<String, String> sortedCatalog = new TreeMap<>(catalog);

        System.out.println("\nAll Books (Sorted by ISBN):");
        for (Map.Entry<String, String> entry : sortedCatalog.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        searchByTitle(catalog, "Operating Systems");
        searchByTitle(catalog, "Computer Networks");
    }

    public static void searchByISBN(Map<String, String> catalog, String isbn) {
        if (catalog.containsKey(isbn)) {
            System.out.println("Found: " + catalog.get(isbn));
        } else {
            System.out.println("Book not found");
        }
    }

    public static void searchByTitle(Map<String, String> catalog, String title) {
        boolean found = false;
        for (Map.Entry<String, String> entry : catalog.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(title)) {
                System.out.println("Found ISBN: " + entry.getKey());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found");
        }
    }
}