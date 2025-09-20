package org.example;

import java.util.Objects;

/**
 * The Clothing class represents an item of clothing with several properties.
 */
class Clothing {
    private final String type;       // e.g., T-shirt, Jacket
    private final String brand;      // e.g., Nike, Adidas
    private final String color;      // e.g., Red, Black
    private final double price;      // price in USD
    private final int size;          // numeric size (e.g., 40, 42)

    /**
     * Constructs a Clothing object with specified properties.
     *
     * @param type  the type of clothing
     * @param brand the brand name
     * @param color the color of clothing
     * @param price the price of clothing
     * @param size  the size of clothing
     */
    public Clothing(String type, String brand, String color, double price, int size) {
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.size = size;
    }
}
