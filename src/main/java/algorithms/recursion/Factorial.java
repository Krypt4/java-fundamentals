package algorithms.recursion;


import java.util.logging.Level;
import java.util.logging.Logger;

/*

    https://www.geeksforgeeks.org/java/java-program-for-factorial-of-a-number/

 * Factorial: the classic introductory example to recursion
 * n! = n * (n-1) * (n-2) * ... * 1

*/

public class Factorial {

    private static final Logger LOGGER = Logger.getLogger(Factorial.class.getName());

    // Recursive implementation
    public static long recursive(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        if (n <= 1) {
            return 1; // Base case
        }
        return n * recursive(n - 1); // Recursive call
    }

    // Iterative implementation
    public static long iterative(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main() {

        int number = 10;

        LOGGER.log(Level.INFO, "{0}! (recursive) = {1}", new Object[]{number, recursive(number)});
        LOGGER.log(Level.INFO, "{0}! (iterative) = {1}", new Object[]{number, iterative(number)});
    }
}