package collections;

import java.util.*;
import java.util.logging.*;

/*

 * Lists: ArrayList and LinkedList (List interface)

*/

public class ListsExample {

    private static final Logger logger = Logger.getLogger(ListsExample.class.getName());

    public static void main() {

        // ArrayList: Fast access by index, ideal for frequent reads
        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // Insert at a specific position
        fruits.add(1, "Kiwi");

        // Log the entire list using a single log statement to avoid multiple evaluations
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "Fruit list: {0}", fruits);
        }

        // Accessing elements and checking for existence
        String elementAtIndex2 = fruits.get(2);
        boolean containsOrange = fruits.contains("Orange");

        // Log the accessed elements and existence check results
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "Element at index 2: {0}", elementAtIndex2);
            logger.log(Level.INFO, "Contains ''Orange''?: {0}", containsOrange);
        }

        fruits.remove("Kiwi");

        // Log the list after removing an element
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "After removing ''Kiwi'': {0}", fruits);
        }

        // Iteration / Traversal
        StringBuilder traversalResult = new StringBuilder("Traversal: ");
        for (String fruit : fruits) {
            traversalResult.append(fruit).append(" | ");
        }

        // Log the traversal result
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "{0}", traversalResult);
        }

        // LinkedList: Efficient for frequent insertions and deletions
        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);

        // Adds to the beginning
        numbers.addFirst(5);

        // Adds to the end
        numbers.addLast(30);

        // Log the entire LinkedList
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "LinkedList: {0}", numbers);
        }

        // Accessing first and last elements
        Integer first = numbers.getFirst();
        Integer last = numbers.getLast();

        // Log the first and last elements of the LinkedList
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "First: {0} | Last: {1}", new Object[]{first, last});
        }
    }
}