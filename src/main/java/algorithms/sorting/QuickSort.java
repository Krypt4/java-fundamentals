package algorithms.sorting;

import java.util.*;
import java.util.logging.*;

/*

    https://www.geeksforgeeks.org/dsa/java-program-for-quicksort/

 * Complexity: O(n log n) average | O(n^2) worst case | O(log n) space (recursion stack)
 * One of the most widely used sorting algorithms in practice

*/

public class QuickSort {

    private static final Logger LOGGER = Logger.getLogger(QuickSort.class.getName());

    // Private constructor to prevent instantiation (Utility Class)
    private QuickSort() {
        throw new IllegalStateException("Utility class");
    }

    // The main function that implements QuickSort
    public static void sort(int[] arr, int low, int high) {

        // Check for null or empty array to avoid unnecessary processing
        if (arr == null || arr.length == 0) {
            return;
        }

        // Check if the low index is less than the high index to ensure there are elements to sort
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            sort(arr, low, pivotIndex - 1);  // Sort the left half
            sort(arr, pivotIndex + 1, high); // Sort the right half
        }
    }

    // Chooses the last element as the pivot, places the pivot element at its correct position in sorted array,
    // and places all smaller elements to the left of the pivot and all greater elements to the right of the pivot
    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1; // Index of the last element smaller than the pivot

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1; // Final pivot position
    }

    // Basic swap function to exchange two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main() {

        int[] data = {10, 7, 8, 9, 1, 5};

        // Log the array before sorting
        LOGGER.info(() -> "Before: " + Arrays.toString(data));

        // Sort the array using QuickSort
        sort(data, 0, data.length - 1);

        // Log the array after sorting
        LOGGER.info(() -> "After:  " + Arrays.toString(data));
    }
}