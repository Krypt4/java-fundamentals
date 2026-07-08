package basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

 * Technical demonstration of basic data types in Java

*/

public class DataTypes {

    private static final Logger logger = LoggerFactory.getLogger(DataTypes.class);

    public static void main(){

        byte exampleByte = 127;
        short exampleShort = 32000;
        int exampleInt = 2_000_000_000;
        long exampleLong = 9_000_000_000L;

        float exampleFloat = 3.14f;
        double exampleDouble = 3.14159265359;

        char exampleChar = 'A';
        boolean exampleBoolean = true;

        logger.info("byte: {} (range: {} a {})", exampleByte, Byte.MIN_VALUE, Byte.MAX_VALUE);
        logger.info("short: {} (range: {} a {})", exampleShort, Short.MIN_VALUE, Short.MAX_VALUE);
        logger.info("int: {} (range: {} a {})", exampleInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
        logger.info("long: {} (range: {} a {})", exampleLong, Long.MIN_VALUE, Long.MAX_VALUE);
        logger.info("float: {}", exampleFloat);
        logger.info("double: {}", exampleDouble);
        logger.info("char: {} (code Unicode: {})", exampleChar, (int) exampleChar);
        logger.info("boolean: {}", exampleBoolean);

        String exampleString = "This is a string";
        logger.info("String: {} | length: {}", exampleString, exampleString.length());

    }
}