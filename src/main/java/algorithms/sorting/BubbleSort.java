package algorithms.sorting;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

    https://www.geeksforgeeks.org/dsa/java-program-for-bubble-sort/

 * Complexity: O(n^2) time | O(1) space
 * The simplest to understand, but inefficient for large lists

*/

public class BubbleSort {

    private static final Logger LOGGER = Logger.getLogger(BubbleSort.class.getName());

    public static void sort(int[] arr) {

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

        LOGGER.log(Level.INFO, "Before: {0}", Arrays.toString(data));
        sort(data);
        LOGGER.log(Level.INFO, "After:  {0}", Arrays.toString(data));
    }
}