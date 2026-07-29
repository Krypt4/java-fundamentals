package algorithms.dynamic_programming;

import java.util.logging.Level;
import java.util.logging.Logger;

/*

    https://www.geeksforgeeks.org/java/java-program-for-dynamic-programming-set-10-0-1-knapsack-problem/

 * Knapsack 0/1 Problem: one of the most asked dynamic programming problems
 * Given a set of items with weight and value, and a knapsack with limited capacity, maximize total value without exceeding capacity
 * Each item can be picked at most once (hence "0/1")
 * Complexity: O(n * capacity) time and space

*/

public class Knapsack01 {

    private static final Logger LOGGER = Logger.getLogger(Knapsack01.class.getName());

    public static int solve(int[] weights, int[] values, int capacity) {

        // Validate input
        if (weights == null || values == null || weights.length != values.length) {
            throw new IllegalArgumentException("Weights and values arrays must be non-null and have the same length.");
        }

        //  We put the length of the weights array into n, which represents the number of items available for selection in the knapsack problem.
        //  This is crucial for setting up the dynamic programming table that will be used to compute the maximum value achievable within the given capacity constraints.
        int n = weights.length;

        // 2D array with dimensions (n + 1) x (capacity + 1).
        // The extra row and column (hence n + 1 and capacity + 1) are used to handle the base case where no items are considered (i = 0) or the capacity is zero (c = 0).
        // This table will be filled iteratively to store the maximum values achievable for different combinations of items and capacities.
        int[][] table = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {

            //  The inner loop iterates over all possible capacities from 0 to the maximum capacity of the knapsack.
            //  For each item (indexed by i), it checks whether the item's weight exceeds the current capacity (c).
            for (int c = 0; c <= capacity; c++) {
                int currentWeight = weights[i - 1];
                int currentValue = values[i - 1];

                //  If the item cannot fit, it retains the maximum value from the previous row (without including the current item)
                if (currentWeight > c) {
                    // Item does not fit: keep best value without it
                    table[i][c] = table[i - 1][c];
                }
                //  If the item can fit, it calculates two scenarios: one where the item is excluded and one where it is included, and stores the maximum of these two values in the table.
                //  This process builds up the solution iteratively, ultimately allowing us to find the maximum value that can be achieved with the given items and capacity.
                else {
                    // Choose maximum between: exclude it, or include it
                    int withoutItem = table[i - 1][c];
                    int withItem = currentValue + table[i - 1][c - currentWeight];
                    table[i][c] = Math.max(withoutItem, withItem);
                }
            }
        }
        return table[n][capacity];
    }

    public static void main() {

        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        int maxValue = solve(weights, values, capacity);
        LOGGER.log(Level.INFO, "Knapsack capacity: {0}", capacity);
        LOGGER.log(Level.INFO, "Maximum achievable value: {0}", maxValue);
    }
}