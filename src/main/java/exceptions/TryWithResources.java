package exceptions;

import java.io.*;
import java.nio.file.*;
import java.util.logging.*;

/*

 * Try with resources, automatic closing of resources that implement
 AutoCloseable without the need for a manual finally block.

*/

// Custom resource implementing AutoCloseable
class SimulatedConnection implements AutoCloseable {

    private static final Logger connectionLogger = Logger.getLogger(SimulatedConnection.class.getName());
    private final String name;

    // Constructor to initialize the resource
    SimulatedConnection(String name) {
        this.name = name;
        connectionLogger.log(Level.INFO, "Opening connection: {0}", name);
    }

    // Method to execute a query
    void executeQuery() {
        connectionLogger.log(Level.INFO, "{0} executing a query...", name);
    }

    // Method to close the connection
    @Override
    public void close() {
        // This method is automatically called when exiting the try block
        connectionLogger.log(Level.INFO, "Closing connection: {0}", name);
    }
}

public class TryWithResources {

    private static final Logger logger = Logger.getLogger(TryWithResources.class.getName());

    public static void main() throws IOException {

        // Example 1 | Custom resource
        try (SimulatedConnection connection = new SimulatedConnection("Database")) {
            connection.executeQuery();
        }
        // Here connection is already automatically closed even if an exception had occurred

        // Example 2 | Writing to a file with automatic closing
        Path tempFile = Path.of("temp_output.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile.toFile()))) {
            writer.write("Line written using try-with-resources.");
        }
        logger.log(Level.INFO, "File written successfully at: {0}", tempFile.toAbsolutePath());

        // Clean up to avoid leaving residual files after execution
        Files.deleteIfExists(tempFile);
    }
}