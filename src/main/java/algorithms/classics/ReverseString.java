package algorithms.classics;

import java.util.logging.*;

/*

    https://www.geeksforgeeks.org/java/reverse-a-string-in-java/

 * Reverse a String without using built-in methods like StringBuilder.reverse()

*/

public class ReverseString {

    private static final Logger LOGGER = Logger.getLogger(ReverseString.class.getName());

    // Private constructor to prevent instantiation
    private ReverseString() {
        throw new IllegalStateException("Utility class");
    }

    // Manual approach: Two pointers swapping characters in a char array
    public static String reverseManual(String text) {

        if (text == null) {
            return null;
        }

        char[] chars = text.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        // Swap characters until the pointers meet in the middle
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    // Recursive approach
    public static String reverseRecursive(String text) {

        if (text == null) {
            return null;
        }
        if (text.isEmpty()) {
            return text;
        }
        return reverseRecursive(text.substring(1)) + text.charAt(0);
    }

    public static void main() {

        String original = "Java Fundamentals";

        // Logging the original and reversed strings using both methods
        LOGGER.info(() -> "Original:             " + original);
        LOGGER.info(() -> "Reversed (manual):    " + reverseManual(original));
        LOGGER.info(() -> "Reversed (recursive): " + reverseRecursive(original));

        // Demonstrating the built-in method for comparison
        String withStringBuilder = new StringBuilder(original).reverse().toString();
        LOGGER.info(() -> "Reversed (built-in):  " + withStringBuilder);
    }
}