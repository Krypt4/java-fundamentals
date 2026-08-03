package algorithms.recursion;

import java.util.*;
import java.util.logging.*;

/*
    https://www.geeksforgeeks.org/java/java-fibonacci-series/

 * Fibonacci: one of the most famous recursion exercises
 * Compares simple recursive version (exponential, O(2^n)) with
 memoization version (O(n)) and iterative version (O(n), no recursion)

*/

public class Fibonacci {

    private static final Logger LOGGER = Logger.getLogger(Fibonacci.class.getName());

    // Private constructor to prevent instantiation (Utility Class)
    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    // Simple recursion | Very inefficient for large n (recalculates the same values repeatedly)
    public static long simpleRecursive(int n) {

        // Check for negative input to avoid invalid Fibonacci calculations
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        if (n <= 1) {
            return n; // Base cases: fib(0)=0, fib(1)=1
        }
        return simpleRecursive(n - 1) + simpleRecursive(n - 2);
    }

    // Recursion with memoization | Stores already computed results (top-down dynamic programming)
    public static long withMemoization(int n, Map<Integer, Long> memo) {

        // Check for negative input to avoid invalid Fibonacci calculations
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n); // Already computed
        }

        // Compute and store the result in the memoization map
        long result = withMemoization(n - 1, memo) + withMemoization(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    // Iterative | No recursion, O(n) time and O(1) space
    public static long iterative(int n) {

        // Check for negative input to avoid invalid Fibonacci calculations
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        if (n <= 1) {
            return n;
        }

        // Iteratively compute Fibonacci numbers using two variables to store the last two computed values
        long previous = 0;
        long current = 1;

        // Iterate from 2 to n, updating the previous and current Fibonacci numbers
        for (int i = 2; i <= n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    public static void main() {

        int n = 15;

        // Demonstrate the different Fibonacci implementations using lazy-evaluation lambdas
        LOGGER.info(() -> String.format("--- Fibonacci of %d ---", n));
        LOGGER.info(() -> String.format("Simple recursive: %d", simpleRecursive(n)));
        LOGGER.info(() -> String.format("With memoization: %d", withMemoization(n, new HashMap<>())));
        LOGGER.info(() -> String.format("Iterative:        %d", iterative(n)));

        LOGGER.info("--- Complete sequence (0 to 10) ---");

        // Generate and log the complete Fibonacci sequence from 0 to 10 using the iterative method
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i <= 10; i++) {
            sequence.append(iterative(i)).append(" ");
        }

        // Log the complete Fibonacci sequence from 0 to 10 using the iterative method
        LOGGER.info(() -> sequence.toString().trim());
    }
}