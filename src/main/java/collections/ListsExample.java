package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

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

        logger.info("Fruit list: " + fruits);
        logger.info("Element at index 2: " + fruits.get(2));
        logger.info("Contains 'Orange'?: " + fruits.contains("Orange"));

        fruits.remove("Kiwi");
        logger.info("After removing 'Kiwi': " + fruits);

        // Iteration / Traversal
        StringBuilder traversalResult = new StringBuilder("Traversal: ");
        for (String fruit : fruits) {
            traversalResult.append(fruit).append(" | ");
        }
        logger.info(traversalResult.toString());

        // LinkedList: Efficient for frequent insertions and deletions
        LinkedList<Integer> numbers = new LinkedList<>();
        
        numbers.add(10);
        numbers.add(20);

        // Adds to the beginning
        numbers.addFirst(5);

        // Adds to the end
        numbers.addLast(30);

        logger.info("LinkedList: " + numbers);
        logger.info("First: " + numbers.getFirst() + " | Last: " + numbers.getLast());
    }
}