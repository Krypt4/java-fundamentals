package oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

 * Abstract classes serve as templates that cannot be directly instantiated,
 featuring a mix of abstract methods without bodies and concrete methods with implementations.

 * They are designed to be subclassed, allowing for a combination of enforced structure and shared functionality.

*/


abstract class Employee {

    Logger logger = LoggerFactory.getLogger(Employee.class);

    protected String name;
    protected double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Abstract method: Every subclass MUST implement it
    abstract double calculateSalary();

    // Concrete method: Shared by all subclasses
    void showInfo() {

        logger.info("{} -> Salary: {}", name, calculateSalary());
    }
}

// Concrete subclass that inherits from Employee
class FullTimeEmployee extends Employee {

    // Constructor that calls the superclass constructor
    FullTimeEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    // Overriding the abstract method from the superclass
    @Override
    double calculateSalary() {
        return baseSalary; // Fixed salary, no variations
    }
}

// Concrete subclass that inherits from Employee
class CommissionEmployee extends Employee {

    private final double commissions;

    // Constructor that calls the superclass constructor and initializes commissions attribute
    CommissionEmployee(String name, double baseSalary, double commissions) {

        super(name, baseSalary);
        this.commissions = commissions;
    }

    // Overriding the abstract method from the superclass
    @Override
    double calculateSalary() {
        return baseSalary + commissions;
    }
}

public class AbstractClasses {

    public static void main(){

        Employee e1 = new FullTimeEmployee("exampleName1", 1800);
        Employee e2 = new CommissionEmployee("exampleName2", 1200, 650);

        e1.showInfo();
        e2.showInfo();
    }
}