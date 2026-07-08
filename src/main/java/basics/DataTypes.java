package basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

 * Technical demonstration of basic data types in Java

*/

public class DataTypes {

    private static final Logger logger = LoggerFactory.getLogger(DataTypes.class);

    public static void main(){

        // Byte: -128 to 127
        // Definition: 8-bit signed integer
        byte exampleByte = 127;

        // Short: -32,768 to 32,767
        // Definition: 16-bit signed integer
        short exampleShort = 32000;

        // Int: -2,147,483,648 to 2,147,483,647
        // Definition: 32-bit signed integer
        int exampleInt = 2_000_000_000;

        // Long: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        // Definition: 64-bit signed integer
        long exampleLong = 9_000_000_000L;

        // Definition: 32-bit floating-point number
        float exampleFloat = 3.14f;

        // Definition: 64-bit floating-point number
        double exampleDouble = 3.14159265359;

        // Definition: 16-bit Unicode character
        char exampleChar = 'A';

        // Definition: true or false
        boolean exampleBoolean = true;

        // Printing values and data types
        logger.info("byte: {} (range: {} a {})", exampleByte, Byte.MIN_VALUE, Byte.MAX_VALUE);
        logger.info("short: {} (range: {} a {})", exampleShort, Short.MIN_VALUE, Short.MAX_VALUE);
        logger.info("int: {} (range: {} a {})", exampleInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
        logger.info("long: {} (range: {} a {})", exampleLong, Long.MIN_VALUE, Long.MAX_VALUE);
        logger.info("float: {}", exampleFloat);
        logger.info("double: {}", exampleDouble);
        logger.info("char: {} (code Unicode: {})", exampleChar, (int) exampleChar);
        logger.info("boolean: {}", exampleBoolean);

        // Definition: String of characters
        String exampleString = "This is a string";
        logger.info("String: {} | length: {}", exampleString, exampleString.length());
    }
}