package oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

 * Polymorphism: a parent type reference can point to child objects,
 and the executed method depends on the actual object type (dynamic dispatch).

*/

// Base class (superclass)
class Shape {

    // Abstract method: Every subclass MUST implement it
    double calculateArea() {
        return 0.0;
    }

    // Concrete method: Shared by all subclasses
    String name() {
        return "Generic shape";
    }
}

// Derived class (subclass) that inherits from Shape
class Circle extends Shape {

    // Constructor that calls the superclass constructor
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    // Overriding the abstract method from the superclass
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Overriding the concrete method from the superclass
    @Override
    String name() {
        return "Circle";
    }
}

// Derived class (subclass) that inherits from Shape
class Rectangle extends Shape {

    // Constructor that calls the superclass constructor
    double base, height;

    Rectangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Overriding the abstract method from the superclass
    @Override
    double calculateArea() {
        return base * height;
    }

    // Overriding the concrete method from the superclass
    @Override
    String name() {
        return "Rectangle";
    }
}

public class Polymorphism {

    private static final Logger logger = LoggerFactory.getLogger(Polymorphism.class);

    public static void main() {

        // Array of type Shape containing different concrete objects
        Shape[] shapes = {
                new Circle(3),
                new Rectangle(4, 5)
        };

        // The correct method is called based on the ACTUAL type of the object
        for (Shape f : shapes) {
            logger.info("{} -> area: {}", f.name(), f.calculateArea());
        }
    }
}