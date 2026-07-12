package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

 * Sorting custom objects with Comparable (natural ordering) and Comparator (external ordering)

*/

// Class to be sorted by price
class Product implements Comparable<Product> {

    String name;
    double price;

    // Constructor to initialize the name and price attributes
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Natural ordering sorted by price ascending
    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }

    // String representation for logging
    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ComparatorsExample {

    private static final Logger logger = Logger.getLogger(ComparatorsExample.class.getName());

    public static void main() {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Keyboard", 45.0));
        products.add(new Product("Monitor", 210.0));
        products.add(new Product("Mouse", 15.5));

        // Natural ordering sorted by price ascending
        products.sort(null);
        logger.log(Level.INFO, "Sorted by price (Comparable): {0}", products);

        // External ordering sorted alphabetically by name
        products.sort(Comparator.comparing(p -> p.name));
        logger.log(Level.INFO, "Sorted by name (Comparator): {0}", products);

        // Comparator with descending order
        products.sort(Comparator.comparingDouble((Product p) -> p.price).reversed());
        logger.log(Level.INFO, "Sorted by price descending: {0}", products);
    }
}