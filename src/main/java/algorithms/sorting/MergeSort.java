package algorithms.sorting;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

    https://www.geeksforgeeks.org/java/java-program-for-merge-sort/

 * Complexity: Always O(n log n) (best, worst, and average) | O(n) extra space
 * Heavily used when guaranteed stability is required or for processing large volumes

*/

public class MergeSort {

    private static final Logger LOGGER = Logger.getLogger(MergeSort.class.getName());

    // Recursively divide the array into halves, sort each half, and then merge them back together
    public static void sort(int[] arr, int start, int end) {

        if (start < end) {

            int mid = start + (end - start) / 2;

            sort(arr, start, mid);            // Sort the left half
            sort(arr, mid + 1, end);    // Sort the right half
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

        LOGGER.log(Level.INFO, "Before: {0}", Arrays.toString(data));
        sort(data, 0, data.length - 1);
        LOGGER.log(Level.INFO, "After:  {0}", Arrays.toString(data));
    }
}