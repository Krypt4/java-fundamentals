package basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

 * Variable declaration, initialization, and casting in Java.

*/

public class Variables {

    private static final Logger logger = LoggerFactory.getLogger(Variables.class);

    public static void main(){

        // Variable declaration and initialization
        int age = 30;
        double height = 1.75;
        boolean isAdult = true;
        char initial = 'J';
        String name = "exampleName";

        // Printing values and data types
        logger.info("Name: {}", name);
        logger.info("Age: {}", age);
        logger.info("Height: {}", height);
        logger.info("Is of legal age: {}", isAdult);
        logger.info("Initial: {}", initial);

        // Constant declaration and initialization
        final double PI = 3.14159;
        logger.info("PI (constant): {}", PI);

        // Implicit casting
        int integerNumber = 10;
        double decimalNumber = integerNumber;
        logger.info("Implicit casting int->double: {}", decimalNumber);

        // Explicit casting
        double decimalValue = 9.99;
        int integerValue = (int) decimalValue;
        logger.info("Explicit casting double->int: {}", integerValue);

        // Extracted method call
        logLocalVariable();
    }

    // Extracted method to handle local variable logging
    private static void logLocalVariable() {
        int localVariable = 5;
        logger.info("Local variable inside the block: {}", localVariable);
    }
}