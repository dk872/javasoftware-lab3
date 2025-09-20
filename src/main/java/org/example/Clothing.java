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
        validateFields(type, brand, color, size, price);

        this.type = type;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.size = size;
    }

    /**
     * Validates constructor arguments.
     *
     * @param type  clothing type
     * @param brand clothing brand
     * @param color clothing color
     * @param size  clothing size
     * @param price clothing price
     * @throws IllegalArgumentException if any parameter is invalid
     */
    private void validateFields(String type, String brand, String color, int size, double price) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty");
        }
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }
}
