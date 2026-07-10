package oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Interfaces: contracts that classes must fulfill.

*/

interface Flyable {
    // Abstract method
    void fly();
}

interface Swimmable {
    // Abstract method
    void swim();
}

// A Duck can fly and swim, so we have to implement both interfaces
class Duck implements Flyable, Swimmable {

    private static final Logger logger = LoggerFactory.getLogger(Duck.class);

    // Implement the abstract methods from the interfaces
    @Override
    public void fly() {
        logger.info("The duck is flying.");
    }

    @Override
    public void swim() {
        logger.info("The duck is swimming.");
    }
}

// Functional interface: It's a protective barrier that keeps the data and code safe within the class itself.
@FunctionalInterface
interface Calculator {

    // Single Abstract Method (SAM) enables Lambda expressions
    int operate(int a, int b);

    // Default method: will provide a default implementation within the interface
    default void showInfo() {
        LoggerFactory.getLogger(Calculator.class).info("I am a generic calculator.");
    }
}

public class Interfaces {

    private static final Logger logger = LoggerFactory.getLogger(Interfaces.class);

    // Private constructor to prevent instantiation from outside the class
    private Interfaces() {
        throw new IllegalStateException("Utility class");
    }

    public static void main() {

        // We create a Duck object and call its methods
        Duck duck = new Duck();
        duck.fly();
        duck.swim();

        // Functional interface implementation using Lambda expressions
        Calculator addition = (a, b) -> a + b;
        Calculator subtraction = (a, b) -> a - b;

        if (logger.isInfoEnabled()) {
            logger.info("Addition result: {}", addition.operate(5, 3));
            logger.info("Subtraction result: {}", subtraction.operate(5, 3));
        }

        // Calling the inherited default method
        addition.showInfo();
    }
}