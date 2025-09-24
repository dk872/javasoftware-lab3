package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The Main class demonstrates usage of the Clothing class:
 * - creating an array of objects
 * - sorting by different fields
 * - searching for an identical object
 */
public class Main {

     /**
     * Main method that runs the demonstration.
     *
     * @param args command-line arguments (not used in this demo)
     */
    public static void main(String[] args) {
        // Create an array of Clothing objects
        Clothing[] clothes = {
                new Clothing("T-shirt", "Nike", "Red", 25.0, 42),
                new Clothing("Jacket", "Adidas", "Black", 120.0, 44),
                new Clothing("Jeans", "Levi's", "Blue", 80.0, 40),
                new Clothing("Sweater", "Puma", "Green", 60.0, 43),
                new Clothing("Sweater", "H&M", "White", 30.0, 41),
                new Clothing("Jacket", "Zara", "Blue", 110.0, 43)
        };

        System.out.println("=== Initial array ===");
        Arrays.stream(clothes).forEach(System.out::println);

        // Sort by type ascending, then brand descending
        sortByTypeAndBrand(clothes);
        System.out.println("\n=== Sorted by type (asc), then brand (desc) ===");
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

    /**
     * Sorts an array of Clothing objects:
     * - first by type ascending (A→Z)
     * - then by brand descending (Z→A) if types are equal
     *
     * @param clothes array of Clothing objects to sort
     */
    private static void sortByTypeAndBrand(Clothing[] clothes) {
        Arrays.sort(clothes,
                Comparator.comparing(Clothing::getType)
                        .thenComparing(Comparator.comparing(Clothing::getBrand).reversed()));
    }
}
