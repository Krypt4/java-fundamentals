package basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

 * Definition of methods, parameters, overloading, and recursion.

*/
public class Methods {

    private static final Logger logger = LoggerFactory.getLogger(Methods.class);

    // Methods with different signatures

    // Method that greets a person by name
    static void greet(String name) {
        logger.info("Hello, {}!", name);
    }

    // Method that adds two numbers and returns the result
    static int add(int a, int b) {
        return a + b;
    }

    // Method that adds two floating-point numbers and returns the result
    static double add(double a, double b) {
        return a + b;
    }

    // Method that adds three numbers and returns the result
    static int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method that calculates the factorial of a number using recursion
    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // Method that adds a variable number of integers and returns the result
    static int addAll(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }

    // Main method to test the above methods
    public static void main() {

        greet("exampleName");

        logger.info("add(2,3) = {}", add(2, 3));
        logger.info("add(2.5,3.5) = {}", add(2.5, 3.5));
        logger.info("add(1,2,3) = {}", add(1, 2, 3));

        logger.info("factorial(5) = {}", factorial(5));

        logger.info("addAll(1,2,3,4,5) = {}", addAll(1, 2, 3, 4, 5));
    }
}