package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    /**
     * Demonstrates usage of the Clothing class:
     * - creating an array of objects
     * - sorting by different fields
     * - searching for an identical object
     */
    public static void main(String[] args) {
        // Create an array of Clothing objects
        Clothing[] clothes = {
                new Clothing("T-shirt", "Nike", "Red", 25.0, 42),
                new Clothing("Jacket", "Adidas", "Black", 120.0, 44),
                new Clothing("Jeans", "Levi's", "Blue", 80.0, 40),
                new Clothing("Sweater", "Puma", "Green", 60.0, 43),
                new Clothing("Shirt", "H&M", "White", 30.0, 41)
        };

        System.out.println("=== Initial array ===");
        Arrays.stream(clothes).forEach(System.out::println);

        // Sort by price (ascending)
        Arrays.sort(clothes, Comparator.comparingDouble(Clothing::getPrice));
        System.out.println("\n=== Sorted by price (ascending) ===");
        Arrays.stream(clothes).forEach(System.out::println);

        // Sort by size (descending)
        Arrays.sort(clothes, Comparator.comparingInt(Clothing::getSize).reversed());
        System.out.println("\n=== Sorted by size (descending) ===");
        Arrays.stream(clothes).forEach(System.out::println);

        // Find an identical object
        Clothing target = new Clothing("Sweater", "Puma", "Green", 60.0, 43);
        int index = Arrays.asList(clothes).indexOf(target);

        if (index >= 0) {
            System.out.println("\nFound identical clothing at index " + index + ": " + clothes[index]);
        } else {
            System.out.println("\nNo identical object found.");
        }
    }
}
