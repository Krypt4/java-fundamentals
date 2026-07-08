package basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

 * Technical demonstration of basic array operations in Java:

    Initialization, manipulation, and traversal of 1D arrays (unidimensional)
    and 2D arrays (matrices) using standard memory management and loops.

*/

public class Arrays {

    private static final Logger logger = LoggerFactory.getLogger(Arrays.class);

	public static void main() {

        // Unidimensional array of integers
        int[] num = {5, 3, 8, 1, 9};
        logger.info("--- Array unidimensional ---");
        logger.info("Elements: ");
        for (int n : num) {
            logger.info("{} ", n);
        }
        logger.info("");
        logger.info("Length: {}", num.length);
        logger.info("First element: {}", num[0]);
        logger.info("Last element: {}", num[num.length - 1]);

        // Unidimensional array of strings
        String[] names = new String[3];
        names[0] = "name0";
        names[1] = "name1";
        names[2] = "name2";
        if (logger.isInfoEnabled()) {
            logger.info("Names: {}", java.util.Arrays.toString(names));
        }

        // Finding the maximum value in the integer array
        int max = num[0];
        for (int n : num) {
            if (n > max) max = n;
        }
        logger.info("Maximum value: {}", max);

        // Cloning and sorting the integer array
        int[] copy = num.clone();
        java.util.Arrays.sort(copy);
        if (logger.isInfoEnabled()) {
            logger.info("Sorted: {}", java.util.Arrays.toString(copy));
        }

        // 2D array of integers
        logger.info("--- Matrix 2D ---");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int line = 0; line < matrix.length; line++) {
            for (int col = 0; col < matrix[line].length; col++) {
                logger.info("{} ", matrix[line][col]);
            }
            logger.info("");
        }
    }
}