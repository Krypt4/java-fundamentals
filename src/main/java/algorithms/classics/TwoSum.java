package algorithms.classics;

import java.util.*;
import java.util.logging.*;

/*

    https://www.geeksforgeeks.org/dsa/check-if-pair-with-given-sum-exists-in-array/

 * Two Sum: Given an array of integers and a target, return indices of the TWO numbers such that they add up to the target
 * Compares the O(n^2) brute force solution with the optimal O(n) solution using a HashMap

*/

public class TwoSum {

    private static final Logger LOGGER = Logger.getLogger(TwoSum.class.getName());

    // Private constructor to prevent instantiation
    private TwoSum() {
        throw new IllegalStateException("Utility class");
    }

    // Brute force: Check every possible pair
    public static int[] bruteForce(int[] numbers, int target) {

        // Check for null input
        if (numbers == null) {
            return new int[]{-1, -1};
        }

        // Check every pair of numbers to see if they sum to the target
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1}; // Not found
    }

    // Optimal: Single pass using a HashMap to store the required complement (value -> index)
    public static int[] withHashMap(int[] numbers, int target) {

        // Check for null input
        if (numbers == null) {
            return new int[]{-1, -1};
        }

        // Create a HashMap to store numbers and their indices
        Map<Integer, Integer> seen = new HashMap<>();

        // Iterate through the array, checking if the complement exists in the HashMap
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(numbers[i], i);
        }
        return new int[]{-1, -1}; // Not found
    }

    public static void main() {

        int[] numbers = {2, 7, 11, 15, 3, 6};
        int target = 9;

        // Run both methods and log the results
        int[] result1 = bruteForce(numbers, target);
        int[] result2 = withHashMap(numbers, target);

        LOGGER.info(() -> "Brute force -> indices: " + Arrays.toString(result1));
        LOGGER.info(() -> "With HashMap -> indices: " + Arrays.toString(result2));
    }
}