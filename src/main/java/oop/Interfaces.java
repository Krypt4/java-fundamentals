package oop;

import java.util.logging.Logger;

/*

 * Interfaces: contracts that classes must fulfill.
 They allow "multiple inheritance" of behavior, as a class can implement multiple interfaces.

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

    private static final Logger logger = Logger.getLogger(Duck.class.getName());

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
        Logger.getLogger(Calculator.class.getName()).info("I am a generic calculator.");
    }
}

public class Interfaces {

    private static final Logger logger = Logger.getLogger(Interfaces.class.getName());

    public static void main() {

        // We create a Duck object and call its methods
        Duck duck = new Duck();
        duck.fly();
        duck.swim();

        // Functional interface implementation using Lambda expressions
        Calculator addition = (a, b) -> a + b;
        Calculator subtraction = (a, b) -> a - b;

        logger.info(String.format("Addition result: %d", addition.operate(5, 3)));
        logger.info(String.format("Subtraction result: %d", subtraction.operate(5, 3)));

        // Calling the inherited default method
        addition.showInfo();
    }
}