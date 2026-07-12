package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

 * Maps: Key-value pairs, HashMap (fast, unordered) and TreeMap (sorted by key)

*/

public class MapsExample {

    private static final Logger logger = Logger.getLogger(MapsExample.class.getName());

    public static void main() {

        // HashMap: Generic, key-value pairs, no guaranteed order
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Ana", 25);
        ages.put("Luis", 30);
        ages.put("Marta", 28);
        ages.put("Ana", 26); // Overwrites the previous value of "Ana"

        logger.log(Level.INFO, "Complete Map: {0}", ages);
        logger.log(Level.INFO, "Luis''s age: {0}", ages.get("Luis"));
        logger.log(Level.INFO, "Does ''Carlos'' exist?: {0}", ages.containsKey("Carlos"));

        // getOrDefault prevents the risk of NullPointerException
        logger.log(Level.INFO, "Carlos''s age (with default value): {0}", ages.getOrDefault("Carlos", 0));

        // Map Traversal
        logger.info("--- Traversal ---");

        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            logger.log(Level.INFO, "{0} -> {1}", new Object[]{entry.getKey(), entry.getValue()});
        }

        // Remove an entry from the map
        ages.remove("Marta");
        logger.log(Level.INFO, "After removing Marta: {0}", ages);

        // TreeMap: Automatically sorts entries by their natural key ordering
        Map<String, Integer> sortedMap = new TreeMap<>(ages);
        logger.log(Level.INFO, "TreeMap (sorted by key): {0}", sortedMap);
    }
}