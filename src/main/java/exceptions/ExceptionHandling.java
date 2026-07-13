package exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/*

 * Exception handling: try / catch / finally, multiple catch blocks, common exceptions

*/

public class ExceptionHandling {

    private static final Logger logger = Logger.getLogger(ExceptionHandling.class.getName());

    public static void main() {

        // Example 1: Division by zero | Arithmetic error (ArithmeticException)
        try {
            int result = 10 / 0;
            logger.log(Level.INFO, "Result: {0}", result); // Never executes
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "Arithmetic error: {0}", e.getMessage());
        }

        // Example 2: Out of bounds access | Array error (ArrayIndexOutOfBoundsException)
        int[] numbers = {1, 2, 3};
        try {
            logger.log(Level.INFO, "{0}", numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.SEVERE, "Index out of bounds: {0}", e.getMessage());
        }

        // Example 3: Multiple catch blocks + finally | Generic error (Exception)
        String text = null;
        try {
            logger.log(Level.INFO, "{0}", text.length()); // NullPointerException
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "Error: null reference.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Generic error: {0}", e.getMessage());
        } finally {
            // Finally will always execute, whether an error occurs or not
            logger.info("Finally block: release any resources here.");
        }

        // Example 4: Invalid conversion (NumberFormatException) | Number format error
        try {
            int parsedNumber = Integer.parseInt("abc"); // NumberFormatException
            logger.log(Level.INFO, "Parsed number: {0}", parsedNumber);
        } catch (NumberFormatException e) {
            logger.info("Could not convert the text to a number.");
        }

        logger.info("The program continues normally after handling all errors.");
    }
}