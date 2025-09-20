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
     * Returns the type of the clothing item.
     *
     * @return a String representing the type (e.g., "T-shirt", "Jacket")
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the brand of the clothing item.
     *
     * @return a String representing the brand (e.g., "Nike", "Adidas")
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Returns the color of the clothing item.
     *
     * @return a String representing the color (e.g., "Red", "Black")
     */
    public String getColor() {
        return color;
    }

    /**
     * Returns the price of the clothing item.
     *
     * @return a double representing the price in USD
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the size of the clothing item.
     *
     * @return an integer representing the numeric size (e.g., 40, 42)
     */
    public int getSize() {
        return size;
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

    /**
     * Provides string representation of the Clothing object.
     *
     * @return string containing clothing details
     */
    @Override
    public String toString() {
        return "Clothing{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }

    /**
     * Compares Clothing objects for equality by all fields.
     *
     * @param obj the object to compare with
     * @return true if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Clothing other)) return false;

        return Double.compare(other.getPrice(), getPrice()) == 0 &&
                other.getSize() == getSize() &&
                Objects.equals(other.getType(), getType()) &&
                Objects.equals(other.getBrand(), getBrand()) &&
                Objects.equals(other.getColor(), getColor());
    }

    /**
     * Returns a hash code value for the Clothing object.
     * The hash code is computed based on all fields (type, brand, color, price, size)
     * to ensure consistency with the equals() method.
     *
     * @return hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(type, brand, color, price, size);
    }
}
