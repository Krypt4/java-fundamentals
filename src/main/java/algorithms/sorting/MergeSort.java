package algorithms.sorting;

import java.util.*;
import java.util.logging.*;

/*

    https://www.geeksforgeeks.org/java/java-program-for-merge-sort/

 * Complexity: Always O(n log n) (best, worst, and average) | O(n) extra space
 * Heavily used when guaranteed stability is required or for processing large volumes

*/

public class MergeSort {

    private static final Logger LOGGER = Logger.getLogger(MergeSort.class.getName());

    // Private constructor to prevent instantiation (Utility Class)
    private MergeSort() {
        throw new IllegalStateException("Utility class");
    }

    // Recursively divide the array into halves, sort each half, and then merge them back together
    public static void sort(int[] arr, int start, int end) {

        // Check for null or empty array to avoid unnecessary processing
        if (arr == null || arr.length == 0) {
            return;
        }

        // Check if the start index is less than the end index to ensure there are elements to sort
        if (start < end) {
            int mid = start + (end - start) / 2;

            sort(arr, start, mid);            // Sort the left half
            sort(arr, mid + 1, end);          // Sort the right half
            merge(arr, start, mid, end);      // Combine both sorted halves
        }
    }

    // Combine two sorted subarrays into a single sorted array
    private static void merge(int[] arr, int start, int mid, int end) {

        // Create temporary arrays to hold the two halves
        int[] left = Arrays.copyOfRange(arr, start, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, end + 1);

        int i = 0;
        int j = 0;
        int k = start;

        // Merge the two sorted subarrays back into the original array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy any remaining elements from either the left or right array
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main() {

        int[] data = {38, 27, 43, 3, 9, 82, 10};

        // Log the array before sorting
        LOGGER.info(() -> "Before: " + Arrays.toString(data));

        // Sort the array using MergeSort
        sort(data, 0, data.length - 1);

        // Log the array after sorting
        LOGGER.info(() -> "After:  " + Arrays.toString(data));
    }
}