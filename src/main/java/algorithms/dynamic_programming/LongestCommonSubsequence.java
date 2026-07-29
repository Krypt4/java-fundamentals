package algorithms.dynamic_programming;

import java.util.logging.Level;
import java.util.logging.Logger;

/*

    https://www.geeksforgeeks.org/dsa/java-program-for-longest-common-subsequence/

 * Longest Common Subsequence (LCS)
 * Classic dynamic programming algorithm used as the foundation for tools like "diff" utilities or DNA sequence aligners
 * Complexity: O(n * m) time and space, where n and m are text lengths

*/

public class LongestCommonSubsequence {

    private static final Logger LOGGER = Logger.getLogger(LongestCommonSubsequence.class.getName());

    // Calculates the length of the longest common subsequence
    public static int calculateLength(String text1, String text2) {

        validateInputs(text1, text2);
        int[][] dpTable = buildDpTable(text1, text2);
        return dpTable[text1.length()][text2.length()];
    }

     // Reconstructs and returns the actual longest common subsequence
    public static String reconstruct(String text1, String text2) {

        validateInputs(text1, text2);
        int[][] dpTable = buildDpTable(text1, text2);

        StringBuilder result = new StringBuilder();
        int i = text1.length();
        int j = text2.length();

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                result.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dpTable[i - 1][j] >= dpTable[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return result.reverse().toString();
    }

    // Helper method to build the DP table, avoiding code duplication
    private static int[][] buildDpTable(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Fill the DP table based on the LCS recurrence relation
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }

    // Validates that the input strings are not null
    private static void validateInputs(String text1, String text2) {
        if (text1 == null || text2 == null) {
            throw new IllegalArgumentException("Input texts must not be null.");
        }
    }

    public static void main() {

        String text1 = "ABCBDAB";
        String text2 = "BDCABA";

        LOGGER.log(Level.INFO, "Text 1: {0}", text1);
        LOGGER.log(Level.INFO, "Text 2: {0}", text2);
        LOGGER.log(Level.INFO, "LCS Length: {0}", calculateLength(text1, text2));
        LOGGER.log(Level.INFO, "Subsequence found: {0}", reconstruct(text1, text2));
    }
}