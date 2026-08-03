package algorithms.sorting;

import java.util.*;
import java.util.logging.*;

/*

    https://www.geeksforgeeks.org/dsa/java-program-for-bubble-sort/

 * Complexity: O(n^2) time | O(1) space
 * The simplest to understand, but inefficient for large lists

*/

public class BubbleSort {

    private static final Logger LOGGER = Logger.getLogger(BubbleSort.class.getName());

    // Private constructor to prevent instantiation (Utility Class)
    private BubbleSort() {
        throw new IllegalStateException("Utility class");
    }

    public static void sort(int[] arr) {

        // Check for null or empty array to avoid unnecessary processing
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            // Each pass places the next largest element in its correct position
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main() {

        int[] data = {64, 34, 25, 12, 22, 11, 90};

        // Log the state of the array before and after sorting for debugging purposes
        LOGGER.info(() -> "Before: " + Arrays.toString(data));

        // Sort the array using the Bubble Sort algorithm
        sort(data);

        // Log the state of the array after sorting to verify correctness
        LOGGER.info(() -> "After:  " + Arrays.toString(data));
    }
}