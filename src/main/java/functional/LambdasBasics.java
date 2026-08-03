package functional;

import java.util.function.*;
import java.util.logging.*;

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

        // Runnable is a functional interface that represents a task to be executed without any parameters and without returning any value.
        // It is often used for creating threads or executing tasks asynchronously.
        Runnable task = () -> LOGGER.info("Running a task with no parameters.");
        task.run();
    }

    // IntUnaryOperator: Specialized to accept an int and return an int
    private static void demonstrateFunction() {

        LOGGER.info("--- Function ---");

        // IntUnaryOperator: Accepts a primitive int and returns a primitive int
        IntUnaryOperator square = n -> n * n;

        // We enter the value 5 to be squared and store the result in a variable
        int result = square.applyAsInt(5);
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "5 squared: {0}", result);
        }
    }

    private static void demonstrateBiFunction() {

        LOGGER.info("--- BiFunction ---");

        // IntBinaryOperator: Accepts two primitive ints and returns a primitive int (No Integer boxing)
        IntBinaryOperator multiply = (a, b) -> a * b;

        // We enter the values 4 and 6 to be multiplied and store the result in a variable
        int result = multiply.applyAsInt(4, 6);
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "4 x 6 = {0}", result);
        }
    }

    private static void demonstratePredicate() {

        LOGGER.info("--- Predicate ---");

        // IntPredicate: Accepts a primitive int and returns a boolean
        IntPredicate isEven = n -> n % 2 == 0;

        boolean isSevenEven = isEven.test(7); // We check if 7 is even and store the result in a variable
        boolean isEightEven = isEven.test(8); // We check if 8 is even and store the result in a variable

        // We log the results of the even checks for 7 and 8
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "Is 7 even?: {0}", isSevenEven);
            LOGGER.log(Level.INFO, "Is 8 even?: {0}", isEightEven);
        }
    }

    private static void demonstrateSupplier() {

        LOGGER.info("--- Supplier ---");

        // Supplier<T>: Accepts no parameters, returns a value of type T
        Supplier<String> messageSupplier = () -> "Dynamically generated message";

        // We call the get() method of the Supplier to retrieve the generated message and store it in a variable
        String message = messageSupplier.get();
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "{0}", message);
        }
    }

    private static void demonstrateMultiLineLambda() {

        LOGGER.info("--- Multi-line Lambda ---");

        // IntFunction<String>: Accepts a primitive int and returns an Object (String)
        IntFunction<String> classifyNumber = n -> {
            if (n < 0) {
                return "Negative";
            }
            if (n == 0) {
                return "Zero";
            }
            return "Positive";
        };

        // We call the apply() method of the IntFunction to classify the number -5 and store the result in a variable
        String classification = classifyNumber.apply(-5);
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "Classification of -5: {0}", classification);
        }
    }

    private static void demonstrateMethodReference() {

        LOGGER.info("--- Method Reference ---");

        // ToIntFunction<String>: Accepts an Object (String) and returns a primitive int
        ToIntFunction<String> stringLength = String::length;

        // We call the applyAsInt() method of the ToIntFunction to get the length of the string "Java" and store the result in a variable
        int length = stringLength.applyAsInt("Java");
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "Length of ''Java'': {0}", length);
        }
    }
}