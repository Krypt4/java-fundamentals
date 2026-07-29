package algorithms.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

    https://www.geeksforgeeks.org/java/java-fibonacci-series/

 * Fibonacci: one of the most famous recursion exercises
 * Compares simple recursive version (exponential, O(2^n)) with
 memoization version (O(n)) and iterative version (O(n), no recursion)

*/

public class Fibonacci {

    private static final Logger LOGGER = Logger.getLogger(Fibonacci.class.getName());

    // Simple recursion | Very inefficient for large n (recalculates the same values repeatedly)
    public static long simpleRecursive(int n) {
        if (n <= 1) {
            return n; // Base cases: fib(0)=0, fib(1)=1
        }
        return simpleRecursive(n - 1) + simpleRecursive(n - 2);
    }

    // Recursion with memoization | Stores already computed results (top-down dynamic programming)
    public static long withMemoization(int n, Map<Integer, Long> memo) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n); // Already computed
        }

        long result = withMemoization(n - 1, memo) + withMemoization(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    // Iterative | No recursion, O(n) time and O(1) space
    public static long iterative(int n) {
        if (n <= 1) {
            return n;
        }
        long previous = 0;
        long current = 1;
        for (int i = 2; i <= n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    public static void main() {

        int n = 15;

        // Demonstrate the different Fibonacci implementations
        LOGGER.log(Level.INFO, "--- Fibonacci of {0} ---", n);
        LOGGER.log(Level.INFO, "Simple recursive: {0}", simpleRecursive(n));
        LOGGER.log(Level.INFO, "With memoization: {0}", withMemoization(n, new HashMap<>()));
        LOGGER.log(Level.INFO, "Iterative:        {0}", iterative(n));

        LOGGER.info("--- Complete sequence (0 to 10) ---");
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i <= 10; i++) {
            sequence.append(iterative(i)).append(" ");
        }
        LOGGER.log(Level.INFO, "{0}", sequence.toString().trim());
    }
}