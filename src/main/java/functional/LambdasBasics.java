package functional;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

// https://www.geeksforgeeks.org/java/lambda-expressions-java-8/

/*

 * Lambda expressions and functional interfaces

*/

public final class LambdasBasics {

    private static final Logger LOGGER = Logger.getLogger(LambdasBasics.class.getName());

    // Private constructor to prevent instantiation
    private LambdasBasics() {
        throw new IllegalStateException("Utility class");
    }

    // Main method to demonstrate Lambda expressions
    public static void main() {
        LOGGER.info("--- Starting Lambda Expressions Demonstration ---");

        demonstrateRunnable();
        demonstrateFunction();
        demonstrateBiFunction();
        demonstratePredicate();
        demonstrateSupplier();
        demonstrateMultiLineLambda();
        demonstrateMethodReference();

        LOGGER.info("--- Demonstration Completed ---");
    }


    // Runnable: Accepts no parameters, returns no value
    private static void demonstrateRunnable() {
        LOGGER.info("--- Runnable ---");
        Runnable task = () -> LOGGER.info("Running a task with no parameters.");
        task.run();
    }


    // Function<T, R>: Accepts one parameter of type T, returns a value of type R
    private static void demonstrateFunction() {
        LOGGER.info("--- Function ---");
        Function<Integer, Integer> square = n -> n * n;
        LOGGER.log(Level.INFO, "5 squared: {0}", square.apply(5));
    }


    // BiFunction<T, U, R>: Accepts two parameters (types T and U), returns type R
    private static void demonstrateBiFunction() {
        LOGGER.info("--- BiFunction ---");
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        LOGGER.log(Level.INFO, "4 x 6 = {0}", multiply.apply(4, 6));
    }

    // Predicate<T>: Accepts one parameter of type T, returns a boolean value
    private static void demonstratePredicate() {
        LOGGER.info("--- Predicate ---");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        LOGGER.log(Level.INFO, "Is 7 even?: {0}", isEven.test(7));
        LOGGER.log(Level.INFO, "Is 8 even?: {0}", isEven.test(8));
    }

    // Supplier<T>: Accepts no parameters, returns a value of type T
    private static void demonstrateSupplier() {
        LOGGER.info("--- Supplier ---");
        Supplier<String> messageSupplier = () -> "Dynamically generated message";
        LOGGER.log(Level.INFO, "{0}", messageSupplier.get());
    }

    // Multi-line Lambda: Shows how to handle conditional blocks inside a Lambda expression
    private static void demonstrateMultiLineLambda() {
        LOGGER.info("--- Multi-line Lambda ---");
        Function<Integer, String> classifyNumber = n -> {
            if (n < 0) {
                return "Negative";
            }
            if (n == 0) {
                return "Zero";
            }
            return "Positive";
        };
        LOGGER.log(Level.INFO, "Classification of -5: {0}", classifyNumber.apply(-5));
    }

    // Method Reference: A shorter, more readable alternative to lambda expressions when only calling an existing method
    private static void demonstrateMethodReference() {
        LOGGER.info("--- Method Reference ---");
        Function<String, Integer> stringLength = String::length;
        LOGGER.log(Level.INFO, "Length of 'Java': {0}", stringLength.apply("Java"));
    }
}