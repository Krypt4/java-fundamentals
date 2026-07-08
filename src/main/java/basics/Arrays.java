package basics;

/*

 * Technical demonstration of basic array operations in Java:

    Initialization, manipulation, and traversal of 1D arrays (unidimensional)
    and 2D arrays (matrices) using standard memory management and loops.

*/

public class Arrays {

	public static void main(String[] args) {

        // Unidimensional array of integers
        int[] num = {5, 3, 8, 1, 9};
        System.out.println("--- Array unidimensional ---");
        System.out.print("Elements: ");
        for (int n : num) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Length: " + num.length);
        System.out.println("First element: " + num[0]);
        System.out.println("Last element: " + num[num.length - 1]);

        // Unidimensional array of strings
        String[] names = new String[3];
        names[0] = "name0";
        names[1] = "name1";
        names[2] = "name2";
        System.out.println("Names: " + java.util.Arrays.toString(names));

        // Finding the maximum value in the integer array
        int max = num[0];
        for (int n : num) {
            if (n > max) max = n;
        }
        System.out.println("Maximum value: " + max);

        // Cloning and sorting the integer array
        int[] copy = num.clone();
        java.util.Arrays.sort(copy);
        System.out.println("Sorted: " + java.util.Arrays.toString(copy));

        // 2D array of integers
        System.out.println("--- Matrix 2D ---");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int line = 0; line < matrix.length; line++) {
            for (int col = 0; col < matrix[line].length; col++) {
                System.out.print(matrix[line][col] + " ");
            }
            System.out.println();
        }
    }
}