package basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

 * Arithmetic, relational, logical, assignment, and ternary operators.

*/

public class Operators {

    private static final Logger logger = LoggerFactory.getLogger(Operators.class);

    public static void main(){

        // Arithmetic Operators
        int a = 10, b = 3;
        logger.info("--- Arithmetic Operators ---");
        logger.info("a + b = {}", a + b);
        logger.info("a - b = {}", a - b);
        logger.info("a * b = {}", a * b);
        logger.info("a / b = {} (integer division)", a / b);
        logger.info("a % b = {} (modulo/remainder)", a % b);

        // Increment and Decrement Operators
        logger.info("--- Increment and Decrement Operators ---");
        int counter = 5;
        logger.info("counter++ = {} | then counter = {}", counter++, counter);
        logger.info("++counter = {}", ++counter);

        // Relational Operators
        logger.info("--- Relational Operators ---");
        logger.info("a > b: {}", a > b);
        logger.info("a == b: {}", a == b);
        logger.info("a != b: {}", a != b);

        // Logical Operators
        logger.info("--- Logical Operators ---");
        boolean p = true, q = false;
        logger.info("p && q = {}", p && q);
        logger.info("p || q = {}", p || q);
        logger.info("!p = {}", !p);

        // Compound Assignment
        logger.info("--- Compound Assignment ---");
        int x = 10;
        x += 5; logger.info("x += 5 -> {}", x);
        x -= 3; logger.info("x -= 3 -> {}", x);
        x *= 2; logger.info("x *= 2 -> {}", x);
        x /= 4; logger.info("x /= 4 -> {}", x);

        // Ternary Operator
        logger.info("--- Ternary Operator ---");
        int number = 7;
        String result = (number % 2 == 0) ? "Even" : "Odd";
        logger.info("{} is {}", number, result);
    }
}