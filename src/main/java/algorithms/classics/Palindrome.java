package algorithms.classics;

import java.text.Normalizer;
import java.util.logging.Logger;

/*

    https://www.geeksforgeeks.org/java/java-program-to-check-whether-a-string-is-a-palindrome/

 * Check if a string is a palindrome (reads the same forwards and backwards)

*/
public class Palindrome {

    private static final Logger LOGGER = Logger.getLogger(Palindrome.class.getName());

    // Private constructor to prevent instantiation (Utility Class)
    private Palindrome() {
        throw new IllegalStateException("Utility class");
    }

    // Two pointers technique: One at the start, one at the end, moving towards the center
    public static boolean isPalindrome(String text) {

        // Handle null input
        if (text == null) {
            return false;
        }

        // Normalize accents/diacritics and strip non-alphanumeric characters
        // This ensures that the palindrome check is case-insensitive and ignores punctuation and spaces
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        String clean = normalized.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = clean.length() - 1;

        // Check characters from both ends towards the center
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Main method for testing the palindrome checker with various cases
    public static void main() {

        // Test cases including palindromes, non-palindromes, empty strings, and null
        String[] testCases = {
            "A man, a plan, a canal: Panama",
            "No 'x' in Nixon",
            "Was it a car or a cat I saw?",
            "Not a palindrome",
            "12321",
            "123456",
            "Able was I ere I saw Elba",
            "Madam In Eden, I'm Adam",
            "Eva, can I see bees in a cave?",
            "Mr. Owl ate my metal worm",
            "Do geese see God?",
            "Never odd or even",
            "This is not a palindrome",
            " ",
            "",
            null
        };

        // Log the results of the palindrome checks for each test case
        for (String test : testCases) {
            String currentTest = test; // Effectively final for lambda scope
            LOGGER.info(() -> String.format("\"%s\" -> Is palindrome?: %b", currentTest, isPalindrome(currentTest)));
        }
    }
}