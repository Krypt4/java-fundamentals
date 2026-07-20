package algorithms.search;

import java.util.logging.Level;
import java.util.logging.Logger;

/*

    https://www.geeksforgeeks.org/java/binary-search-in-java/

 * Complexity: O(log n) — significantly faster than linear search O(n)
 * Essential requirement: the array must be sorted

*/

public class BinarySearch {

    private static final Logger LOGGER = Logger.getLogger(BinarySearch.class.getName());

    // Iterative version
    public static int binarySearchIterative(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;   // Search in the right half
            } else {
                right = mid - 1;  // Search in the left half
            }
        }
        return -1; // Not found
    }

    // Recursive version
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {

        // If the left index exceeds the right index, the target is not present in the array
        if (left > right) {
            return -1; // Base case (not found)
        }

        // Calculate the middle index
        int mid = left + (right - left) / 2;

        // Check if the target is present at mid
        if (arr[mid] == target) {
            return mid;
        }

        // If the target is greater, ignore the left half
        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right); // Search in the right half
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1); // Search in the left half
        }
    }

    public static void main() {

        int[] data = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        int target = 23;

        // Binary search using both iterative method
        LOGGER.log(Level.INFO, "Searching for {0} (iterative): index {1}",
                new Object[]{target, binarySearchIterative(data, target)});

        // Binary search using the recursive method
        LOGGER.log(Level.INFO, "Searching for {0} (recursive): index {1}",
                new Object[]{target, binarySearchRecursive(data, target, 0, data.length - 1)});

        // Binary search for a target that does not exist
        int notFoundTarget = 100;

        LOGGER.log(Level.INFO, "Searching for {0} (does not exist): index {1}",
                new Object[]{notFoundTarget, binarySearchIterative(data, notFoundTarget)});
    }
}