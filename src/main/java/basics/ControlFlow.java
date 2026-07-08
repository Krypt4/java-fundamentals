package basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

 * Control structures: if/else, switch, for, while, do-while.

 */

public class ControlFlow {

    private static final Logger logger = LoggerFactory.getLogger(ControlFlow.class);

    public static void main() {

        // Conditional statements
        int grade = 85;
        logger.info("--- if / else ---");
        if (grade >= 90) {
            logger.info("Excellent");
        } else if (grade >= 70) {
            logger.info("Good");
        } else if (grade >= 50) {
            logger.info("Pass");
        } else {
            logger.info("Fail");
        }

        // Conditional expressions
        logger.info("--- switch ---");
        int dayOfWeek = 3;
        switch (dayOfWeek) {
            case 1:
                logger.info("Monday");
                break;
            case 2:
                logger.info("Tuesday");
                break;
            case 3:
                logger.info("Wednesday");
                break;
            default:
                logger.info("Other day");
        }

        String dayType = switch (dayOfWeek) {
            case 6, 7 -> "Weekend";
            default -> "Weekday";
        };
        logger.info("Day type: {}", dayType);

        // Looping statements
        logger.info("--- for ---");
        for (int i = 1; i <= 5; i++) {
            logger.info("{} ", i);
        }
        logger.info("");

        // Enhanced for loop
        logger.info("--- for-each ---");
        int[] numbers = {10, 20, 30, 40};
        for (int n : numbers) {
            logger.info("{} ", n);
        }
        logger.info("");

        // While and do-while loops
        logger.info("--- while ---");
        int counter = 0;
        while (counter < 3) {
            logger.info("While iteration: {}", counter);
            counter++;
        }

        logger.info("--- do-while ---");
        int value = 0;
        do {
            logger.info("Do-while iteration: {}", value);
            value++;
        } while (value < 3);

        // Loop control statements
        logger.info("--- break and continue ---");
        for (int i = 1; i < 7; i++) {
            if (i % 2 != 0) {
                logger.info("{} ", i);
            }
        }
        logger.info("");
    }
}