package functional;

import java.util.function.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

    https://www.geeksforgeeks.org/java/lambda-expressions-java-8/

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

    // IntUnaryOperator: Specialized to accept an int and return an int
    private static void demonstrateFunction() {
        LOGGER.info("--- Function ---");

        IntUnaryOperator square = n -> n * n;
        LOGGER.log(Level.INFO, "5 squared: {0}", square.applyAsInt(5));
    }

    // IntBinaryOperator: Accepts two primitive ints and returns a primitive int (No Integer boxing)
    private static void demonstrateBiFunction() {
        LOGGER.info("--- BiFunction ---");

        IntBinaryOperator multiply = (a, b) -> a * b;
        LOGGER.log(Level.INFO, "4 x 6 = {0}", multiply.applyAsInt(4, 6));
    }

    // IntPredicate: Accepts a primitive int and returns a boolean
    private static void demonstratePredicate() {
        LOGGER.info("--- Predicate ---");

        IntPredicate isEven = n -> n % 2 == 0;
        LOGGER.log(Level.INFO, "Is 7 even?: {0}", isEven.test(7));
        LOGGER.log(Level.INFO, "Is 8 even?: {0}", isEven.test(8));
    }

    // Supplier<T>: Accepts no parameters, returns a value of type T
    private static void demonstrateSupplier() {
        LOGGER.info("--- Supplier ---");

        Supplier<String> messageSupplier = () -> "Dynamically generated message";
        LOGGER.log(Level.INFO, "{0}", messageSupplier.get());
    }

    // IntFunction<String>: Accepts a primitive int and returns an Object (String)
    private static void demonstrateMultiLineLambda() {
        LOGGER.info("--- Multi-line Lambda ---");

        IntFunction<String> classifyNumber = n -> {
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

    // ToIntFunction<String>: Accepts an Object (String) and returns a primitive int
    private static void demonstrateMethodReference() {
        LOGGER.info("--- Method Reference ---");

        ToIntFunction<String> stringLength = String::length;
        LOGGER.log(Level.INFO, "Length of 'Java': {0}", stringLength.applyAsInt("Java"));
    }
}