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

        // Logging the current state of the list
        logger.info(() -> String.format("Fruit list: %s", fruits));

        // Accessing elements and checking for existence
        String elementAtIndex2 = fruits.get(2);
        boolean containsOrange = fruits.contains("Orange");

        // Logging the accessed element and existence check
        logger.info(() -> String.format("Element at index 2: %s", elementAtIndex2));
        logger.info(() -> String.format("Contains 'Orange'?: %b", containsOrange));

        fruits.remove("Kiwi");

        // Logging the state of the list after removal
        logger.info(() -> String.format("After removing 'Kiwi': %s", fruits));

        // Iteration / Traversal
        StringBuilder traversalResult = new StringBuilder("Traversal: ");
        for (String fruit : fruits) {
            traversalResult.append(fruit).append(" | ");
        }

        // Logging the traversal result
        logger.info(traversalResult::toString);

        // LinkedList: Efficient for frequent insertions and deletions
        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);

        // Adds to the beginning
        numbers.addFirst(5);

        // Adds to the end
        numbers.addLast(30);

        // Logging the current state of the LinkedList
        logger.info(() -> String.format("LinkedList: %s", numbers));

        // Accessing first and last elements
        Integer first = numbers.getFirst();
        Integer last = numbers.getLast();

        // Logging the first and last elements
        logger.info(() -> String.format("First: %s | Last: %s", first, last));
    }
}