package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

        logger.log(Level.INFO, "Fruit list: {0}", fruits);
        logger.log(Level.INFO, "Element at index 2: {0}", fruits.get(2));
        logger.log(Level.INFO, "Contains ''Orange''?: {0}", fruits.contains("Orange"));

        fruits.remove("Kiwi");
        logger.log(Level.INFO, "After removing ''Kiwi'': {0}", fruits);

        // Iteration / Traversal
        StringBuilder traversalResult = new StringBuilder("Traversal: ");
        for (String fruit : fruits) {
            traversalResult.append(fruit).append(" | ");
        }
        logger.log(Level.INFO, "{0}", traversalResult.toString());

        // LinkedList: Efficient for frequent insertions and deletions
        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);

        // Adds to the beginning
        numbers.addFirst(5);

        // Adds to the end
        numbers.addLast(30);

        logger.log(Level.INFO, "LinkedList: {0}", numbers);
        logger.log(Level.INFO, "First: {0} | Last: {1}", new Object[]{numbers.getFirst(), numbers.getLast()});
    }
}