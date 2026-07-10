package oop;

import java.util.logging.Logger;

/*

 * Encapsulation: private attributes + validation rules + custom exceptions.

*/

// Custom exception for insufficient funds
class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Encapsulated class representing a bank account
class BankAccount {

    private static final Logger logger = Logger.getLogger(BankAccount.class.getName());

    // Final prevents the reference from changing after initialization
    private final String holder;
    private double balance;

    // This method will be called only once during object creation, so we can validate the parameters here.
    public BankAccount(String holder, double initialBalance) {

        // Business logic validation
        if (holder == null || holder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.holder = holder;
        this.balance = initialBalance;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    // Business logic validation and logging
    public void deposit(double amount) {
        if (amount <= 0) {
            logger.warning("Deposit failed: Amount must be positive. Attempted: " + amount);
            return;
        }
        balance += amount;
        logger.info("Successfully deposited $" + amount + ". New balance: $" + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            logger.warning("Withdrawal failed: Amount must be positive. Attempted: " + amount);
            return;
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Withdrawal failed: Insufficient funds for amount $" + amount);
        }
        balance -= amount;
        logger.info("Successfully withdrew $" + amount + ". New balance: $" + balance);
    }
}

public class Encapsulation {

    private static final Logger logger = Logger.getLogger(Encapsulation.class.getName());

    public static void main() {

        BankAccount account = new BankAccount("exampleName", 500.0);

        // Successful operations
        account.deposit(150.0);

        try {
            account.withdraw(200.0);
            // Triggering business logic validation inside a try-catch
            account.withdraw(1000.0);
        } catch (InsufficientFundsException e) {
            logger.severe("Exception caught: " + e.getMessage());
        }

        // Testing parameter validation
        account.deposit(-50.0);
    }
}