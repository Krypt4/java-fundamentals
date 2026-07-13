package exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/*

 * Custom exceptions, creating our own business logic error types

*/

// Checked exception: Forces the caller to handle or declare it (extends Exception)
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Unchecked exception: Does not force the caller to handle it (extends RuntimeException)
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            // Checked exception: It must be declared in the method signature or handled in the caller
            throw new InsufficientBalanceException("Insufficient balance. Available: " + balance);
        }
        balance -= amount;
    }
}

public class CustomExceptions {

    private static final Logger logger = Logger.getLogger(CustomExceptions.class.getName());

    // Unchecked exception: It does not need to be declared or handled
    static void validateAge(int age) {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("The age " + age + " is not valid.");
        }
    }

    public static void main() {

        BankAccount account = new BankAccount(100);

        try {
            account.withdraw(500); // Triggers InsufficientBalanceException
        } catch (InsufficientBalanceException e) {
            logger.log(Level.SEVERE, "Operation rejected: {0}", e.getMessage());
        }

        try {
            validateAge(150); // Triggers InvalidAgeException (unchecked)
        } catch (InvalidAgeException e) {
            logger.log(Level.SEVERE, "Invalid data: {0}", e.getMessage());
        }
    }
}