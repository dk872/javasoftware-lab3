package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Clothing class.
 * Covers:
 * - constructor and input validation
 * - equals and hashCode
 * - toString
 * - sorting by fields
 * - searching for identical objects
 */
class ClothingTest {

    @Test
    void testValidClothingCreation() {
        Clothing c = new Clothing("T-shirt", "Nike", "Red", 25.0, 42);

        assertEquals("T-shirt", c.getType());
        assertEquals("Nike", c.getBrand());
        assertEquals("Red", c.getColor());
        assertEquals(25.0, c.getPrice());
        assertEquals(42, c.getSize());
    }

    @Test
    void testInvalidTypeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothing(null, "Nike", "Red", 25.0, 42));
    }

    @Test
    void testInvalidBrandNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothing("T-shirt", null, "Red", 25.0, 42));
    }

    @Test
    void testInvalidColorNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothing("T-shirt", "Nike", null, 25.0, 42));
    }

    @Test
    void testInvalidTypeEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothing("", "Nike", "Red", 25.0, 42));
    }

    @Test
    void testInvalidBrandEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothing("T-shirt", "", "Red", 25.0, 42));
    }

    @Test
    void testInvalidColorEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothing("T-shirt", "Nike", "", 25.0, 42));
    }

    @Test
    void testInvalidSize() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothing("T-shirt", "Nike", "Red", 25.0, 0));
    }

    @Test
    void testInvalidPrice() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothing("T-shirt", "Nike", "Red", -10.0, 42));
    }

    @Test
    void testEqualsAndHashCode() {
        Clothing c1 = new Clothing("Shirt", "H&M", "White", 30.0, 41);
        Clothing c2 = new Clothing("Shirt", "H&M", "White", 30.0, 41);

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void testNotEqualsDifferentPrice() {
        Clothing c1 = new Clothing("Shirt", "H&M", "White", 30.0, 41);
        Clothing c2 = new Clothing("Shirt", "H&M", "White", 40.0, 41);

        assertNotEquals(c1, c2);
    }

    @Test
    void testToStringContainsFields() {
        Clothing c = new Clothing("Jacket", "Adidas", "Black", 120.0, 44);
        String s = c.toString();

        assertTrue(s.contains("Jacket"));
        assertTrue(s.contains("Adidas"));
        assertTrue(s.contains("Black"));
        assertTrue(s.contains("120.0"));
        assertTrue(s.contains("44"));
    }

    @Test
    void testSortByTypeAndBrand() {
        Clothing[] clothes = {
                new Clothing("Jacket", "Adidas", "Black", 120.0, 44),
                new Clothing("Shirt", "H&M", "White", 30.0, 41),
                new Clothing("T-shirt", "Nike", "Red", 25.0, 42),
                new Clothing("Jacket", "Zara", "Blue", 110.0, 43)
        };

        // Sort by type ascending, then brand descending
        Arrays.sort(clothes,
                Comparator.comparing(Clothing::getType)
                        .thenComparing(Comparator.comparing(Clothing::getBrand).reversed()));

        // Expected order:
        // Jacket, Zara
        // Jacket, Adidas
        // Shirt, H&M
        // T-shirt, Nike

        assertEquals("Jacket", clothes[0].getType());
        assertEquals("Zara", clothes[0].getBrand());

        assertEquals("Jacket", clothes[1].getType());
        assertEquals("Adidas", clothes[1].getBrand());

        assertEquals("Shirt", clothes[2].getType());
        assertEquals("H&M", clothes[2].getBrand());

        assertEquals("T-shirt", clothes[3].getType());
        assertEquals("Nike", clothes[3].getBrand());
    }

    @Test
    void testFindIdenticalObject() {
        Clothing[] clothes = {
                new Clothing("Sweater", "Puma", "Green", 60.0, 43),
                new Clothing("Shirt", "H&M", "White", 30.0, 41),
        };
        Clothing target = new Clothing("Sweater", "Puma", "Green", 60.0, 43);
        int index = Arrays.asList(clothes).indexOf(target);

        assertEquals(0, index);
    }

    @Test
    void testFindNonExistentObject() {
        Clothing[] clothes = {
                new Clothing("Sweater", "Puma", "Green", 60.0, 43),
                new Clothing("Shirt", "H&M", "White", 30.0, 41),
        };
        Clothing target = new Clothing("Jeans", "Levi's", "Blue", 80.0, 40);
        int index = Arrays.asList(clothes).indexOf(target);

        assertEquals(-1, index);
    }

    @Test
    void testSortAndFind() {
        // Step 1: create array
        Clothing[] clothes = {
                new Clothing("T-shirt", "Nike", "Red", 25.0, 42),
                new Clothing("Jacket", "Adidas", "Black", 120.0, 44),
                new Clothing("Jeans", "Levi's", "Blue", 80.0, 40),
                new Clothing("Sweater", "Puma", "Green", 60.0, 43),
                new Clothing("Sweater", "H&M", "White", 30.0, 41),
                new Clothing("Jacket", "Zara", "Blue", 110.0, 43)
        };

        // Step 2: sort by type ascending, then brand descending
        Arrays.sort(clothes,
                Comparator.comparing(Clothing::getType)
                        .thenComparing(Comparator.comparing(Clothing::getBrand).reversed()));

        // Step 3: check sorted order
        assertEquals("Jacket", clothes[0].getType());
        assertEquals("Zara", clothes[0].getBrand());

        assertEquals("Jacket", clothes[1].getType());
        assertEquals("Adidas", clothes[1].getBrand());

        assertEquals("Jeans", clothes[2].getType());
        assertEquals("Levi's", clothes[2].getBrand());

        assertEquals("Sweater", clothes[3].getType());
        assertEquals("Puma", clothes[3].getBrand());

        assertEquals("Sweater", clothes[4].getType());
        assertEquals("H&M", clothes[4].getBrand());

        assertEquals("T-shirt", clothes[5].getType());
        assertEquals("Nike", clothes[5].getBrand());

        // Step 4: find identical object
        Clothing target = new Clothing("Sweater", "Puma", "Green", 60.0, 43);
        int index = Arrays.asList(clothes).indexOf(target);

        // Step 5: assertions
        assertTrue(index >= 0, "Target object should be found");
        assertEquals(target, clothes[index], "Found object should equal target");
    }
}
