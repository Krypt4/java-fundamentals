package functional;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

    https://www.hungrycoders.com/blog/understanding-java-streams-with-code-examples

 * Streams: Filter, map, forEach, collect (basic operations on collections)

*/

public class StreamsBasics {

    private static final Logger LOGGER = Logger.getLogger(StreamsBasics.class.getName());

    public static void main() {

        List<String> names = List.of("Ana", "Bruno", "Carla", "David", "Elena", "Bea");

        // I used a filter to get the names starting with 'B' and then collected them into a new list
        LOGGER.log(Level.INFO, "--- filter: names starting with 'B' ---");
        List<String> startingWithB = names.stream()
                .filter(name -> name.startsWith("B"))
                .toList();
        LOGGER.log(Level.INFO, "{0}", startingWithB);

        // I used map to convert each name to uppercase and collect the result into a new list
        LOGGER.log(Level.INFO, "--- map: convert to uppercase ---");
        List<String> uppercaseNames = names.stream()
                .map(String::toUpperCase)
                .toList();
        LOGGER.log(Level.INFO, "{0}", uppercaseNames);

        // Now I used forEach to print each element of the list
        LOGGER.log(Level.INFO, "--- forEach: print each element ---");
        names.forEach(name -> LOGGER.log(Level.INFO, "- {0}", name));

        // I used a chaining of filter, map, and sorted to get names with 4 or fewer letters, convert them to uppercase and sort them
        LOGGER.log(Level.INFO, "--- Chaining filter + map + sorted ---");
        List<String> filteredSortedResult = names.stream()
                .filter(name -> name.length() <= 4)
                .map(String::toUpperCase)
                .sorted()
                .toList();
        LOGGER.log(Level.INFO, "{0}", filteredSortedResult);

        // I used count to get the number of names with more than 4 letters
        LOGGER.log(Level.INFO, "--- count, anyMatch, allMatch ---");
        long countLongNames = names.stream()
                .filter(name -> name.length() > 4)
                .count();

        LOGGER.log(Level.INFO, "Names with more than 4 letters: {0}", countLongNames);

        // Then I used anyMatch to check if any name starts with 'C' and allMatch to check if all names have at least 3 letters
        boolean hasNameWithC = names.stream()
                .anyMatch(name -> name.startsWith("C"));
        LOGGER.log(Level.INFO, "Does any name start with 'C'?: {0}", hasNameWithC);

        // And finally I used allMatch to check if all names have at least 3 letters
        boolean allHaveMinThreeLetters = names.stream()
                .allMatch(name -> name.length() >= 3);
        LOGGER.log(Level.INFO, "Do all names have at least 3 letters?: {0}", allHaveMinThreeLetters);
    }
}