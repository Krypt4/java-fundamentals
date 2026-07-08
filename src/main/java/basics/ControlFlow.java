package basics;

/*

 * Control structures: if/else, switch, for, while, do-while.

 */

public class ControlFlow {

    public static void main(String[] args) {

        // Conditional statements
        int grade = 85;
        System.out.println("--- if / else ---");
        if (grade >= 90) {
            System.out.println("Excellent");
        } else if (grade >= 70) {
            System.out.println("Good");
        } else if (grade >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        // Conditional expressions
        System.out.println("--- switch ---");
        int dayOfWeek = 3;
        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Other day");
        }

        String dayType = switch (dayOfWeek) {
            case 6, 7 -> "Weekend";
            default -> "Weekday";
        };
        System.out.println("Day type: " + dayType);

        // Looping statements
        System.out.println("--- for ---");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Enhanced for loop
        System.out.println("--- for-each ---");
        int[] numbers = {10, 20, 30, 40};
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();

        // While and do-while loops
        System.out.println("--- while ---");
        int counter = 0;
        while (counter < 3) {
            System.out.println("While iteration: " + counter);
            counter++;
        }

        System.out.println("--- do-while ---");
        int value = 0;
        do {
            System.out.println("Do-while iteration: " + value);
            value++;
        } while (value < 3);

        // Loop control statements
        System.out.println("--- break and continue ---");
        for (int i = 1; i <= 10; i++) {
            if (i == 7) break;
            if (i % 2 == 0) continue;
            System.out.print(i + " ");
        }
        System.out.println();
    }
}