package algorithms.classics;

import java.util.logging.*;

/*

    https://www.geeksforgeeks.org/dsa/fizz-buzz-implementation/

 * FizzBuzz: From 1 to 100, print "Fizz" if divisible by 3, "Buzz" if divisible
 * by 5, "FizzBuzz" if divisible by both, and the number itself otherwise

 * I did this basic but interesting exercise in the Madrid 42 entrance exams and
 I thought it would be interesting to be able to transfer it to the Java language

*/

public class FizzBuzz {

    private static final Logger LOGGER = Logger.getLogger(FizzBuzz.class.getName());

    // Constants for divisors
    private static final int DIVISOR_THREE = 3;
    private static final int DIVISOR_FIVE = 5;
    private static final int MAX_RANGE = 100;

    // Evaluates a number and returns its corresponding FizzBuzz String representation.
    public static String getFizzBuzzValue(int number) {

        boolean isDivisibleByThree = number % DIVISOR_THREE == 0;
        boolean isDivisibleByFive = number % DIVISOR_FIVE == 0;

        // Check divisibility and return the appropriate FizzBuzz value
        if (isDivisibleByThree && isDivisibleByFive) {
            return "FizzBuzz";
        } else if (isDivisibleByThree) {
            return "Fizz";
        } else if (isDivisibleByFive) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }

    public static void main() {

        // Print FizzBuzz values for numbers from 1 to MAX_RANGE (100)
        for (int i = 1; i <= MAX_RANGE; i++) {
            int current = i;
            LOGGER.log(Level.INFO, () -> getFizzBuzzValue(current));
        }
    }
}