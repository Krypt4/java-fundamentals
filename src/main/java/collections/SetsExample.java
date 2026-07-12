package collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

 * Sets: HashSet (no guaranteed order, duplicates not allowed) and TreeSet (sorted)

*/

public class SetsExample {

    private static final Logger logger = Logger.getLogger(SetsExample.class.getName());

    public static void main() {

        // HashSet: Generic, no duplicates allowed
        Set<String> colors = new HashSet<>();

        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Red"); // Duplicate: Will be ignored silently

        logger.log(Level.INFO, "HashSet (no duplicates): {0}", colors);
        logger.log(Level.INFO, "Size: {0}", colors.size());

        // In MessageFormat, single quotes are escaped by doubling them (''Green'')
        logger.log(Level.INFO, "Contains ''Green''?: {0}", colors.contains("Green"));

        // TreeSet: Automatically keeps elements sorted in their natural order (or custom comparator)
        Set<Integer> sortedNumbers = new TreeSet<>();

        sortedNumbers.add(50);
        sortedNumbers.add(10);
        sortedNumbers.add(30);
        sortedNumbers.add(20);

        logger.log(Level.INFO, "TreeSet (sorted): {0}", sortedNumbers);
    }
}