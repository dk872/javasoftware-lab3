# Java_software-lab3

## Description
This project demonstrates a simple Clothing management program in Java. It allows creating clothing items with multiple properties, sorting them by different fields, and searching for identical items in an array. The project showcases object-oriented principles, array manipulation, and use of standard Java utilities for sorting and comparison. 

## Calculation of the task variant
Number in the group list: **15**;

C11 = 15 % 11 = **4**.

## Features
- Create Clothing objects with type, brand, color, price, and size.
- Validate object fields to prevent invalid data.
- Sort an array of clothing items by price in ascending order.
- Sort an array of clothing items by size in descending order.
- Search for an identical clothing object in the array.
- Display the initial array, sorted arrays, and search results in the console.
- Includes overridden equals(), hashCode(), and toString() methods for proper object comparison and display.

## How to run
First, clone the repository and navigate into the project directory:
```
git clone https://github.com/dk872/javasoftware-lab3
```
```
cd javasoftware-lab3
```

Compile the code:
```
javac src/main/java/org/example/*.java
```

Run the program:
```
java -cp src/main/java org.example.Main
```

## Unit tests
This project includes **16** unit tests using JUnit 5 to ensure the correctness of all core functionalities, including:

- Creating valid Clothing objects and verifying their fields.
- Handling invalid input values for type, brand, color, size, and price.
- Verifying `equals()` and `hashCode()` methods for object comparison.
- Testing `toString()` output contains all fields.
- Sorting arrays of Clothing objects by price (ascending) and size (descending).
- Finding identical objects in an array and handling non-existent objects.
- Combined operations: sorting and then searching for an identical object.

### How to run tests
Make sure you have JUnit 5 configured, then run the tests with your preferred method:
  - From command line
  ```
  mvn test
  ```
  - In an IDE like IntelliJ IDEA or Eclipse using the test runner.

## Author info
Dmytro Kulyk, a student of group IM-32.
