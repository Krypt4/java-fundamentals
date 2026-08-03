package algorithms.classics;

import java.util.*;
import java.util.logging.*;

/*

    https://www.geeksforgeeks.org/java/java-prime-number-program/

 * Prime Numbers: Individual verification + Sieve of Eratosthenes (algorithm to find all primes up to N)
 * Single check complexity: O(√n)
 * Sieve of Eratosthenes complexity: O(n log log n)

*/

public class PrimeNumbers {

    private static final Logger LOGGER = Logger.getLogger(PrimeNumbers.class.getName());

    // Checks if a single number is prime
    public static boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }
        for (int i = 2; (long) i * i <= n; i++) { // Only check up to square root
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Sieve of Eratosthenes: Efficiently finds all prime numbers up to 'limit'
    public static List<Integer> sieveOfEratosthenes(int limit) {

        // If the limit is less than 2, return an empty list since there are no primes below 2
        if (limit < 2) {
            return List.of();
        }

        // Create a boolean array to mark composite numbers. Initially, all numbers are assumed to be prime (false).
        boolean[] isComposite = new boolean[limit + 1];
        List<Integer> primes = new ArrayList<>();

        // Iterate through numbers starting from 2 up to the limit
        for (int i = 2; i <= limit; i++) {
            if (!isComposite[i]) {
                primes.add(i);
                // Mark all multiples of i as composite (not prime)
                for (long j = (long) i * i; j <= limit; j += i) {
                    isComposite[(int) j] = true;
                }
            }
        }
        return primes;
    }

    public static void main() {

        // Check if a specific number is prime with the method isPrime
        int number = 29;
        LOGGER.log(Level.INFO, "Is {0} prime?: {1}", new Object[]{number, isPrime(number)});

        // Find all prime numbers up to a certain limit using the Sieve of Eratosthenes
        int limit = 50;
        LOGGER.log(Level.INFO, "Primes up to {0}: {1}", new Object[]{limit, sieveOfEratosthenes(limit)});
    }
}