package functional;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*

    https://blog.tangly.net/blog/2024/advanced-streams/

 * Advanced flows: Reduce, groupBy, sorted with comparator, statistics

*/

// Employee class to demonstrate
class Employee {
    private final String name;
    private final String department;
    private final double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters for name, department, and salary
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }

    // String representation of the employee for logging
    @Override
    public String toString() {
        return name + " (" + department + ", $" + salary + ")";
    }
}

public class AdvancedStreams {

    private static final Logger LOGGER = Logger.getLogger(AdvancedStreams.class.getName());

    public static void main() {

        // List of employees
        List<Employee> employees = List.of(
                new Employee("Ana", "Sales", 2200),
                new Employee("Luis", "IT", 2800),
                new Employee("Marta", "Sales", 2100),
                new Employee("Pedro", "IT", 3000),
                new Employee("Sofia", "HR", 1900)
        );

        // reduce: Sum all salaries
        double totalSalaries = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        LOGGER.log(Level.INFO, "Total salaries: {0}", totalSalaries);

        // groupingBy: Group employees by department
        Map<String, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        LOGGER.info("--- Grouped by department ---");
        byDepartment.forEach((dept, list) ->
                LOGGER.log(Level.INFO, "{0} -> {1}", new Object[]{dept, list})
        );

        // groupingBy + counting: How many employees per department
        Map<String, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        LOGGER.log(Level.INFO, "Count by department: {0}", countByDept);

        // sorted with Comparator: Sort by salary descending
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();
        LOGGER.info("--- Sorted by salary (desc) ---");
        sortedBySalary.forEach(emp -> LOGGER.log(Level.INFO, "{0}", emp));

        // Statistics: min, max, average
        doubleSummaryStatisticsWrapper();

        // IntStream: Generate and sum a range of numbers
        int rangeSum = IntStream.rangeClosed(1, 10).sum();
        LOGGER.log(Level.INFO, "Sum from 1 to 10 with IntStream: {0}", rangeSum);
    }

    // Demonstrates how to calculate statistics (min, max, average) for a list of salaries using DoubleSummaryStatistics
    static void doubleSummaryStatisticsWrapper() {

        // List of salaries
        List<Double> salaries = List.of(2200.0, 2800.0, 2100.0, 3000.0, 1900.0);
        DoubleSummaryStatistics stats = salaries.stream()
                .mapToDouble(Double::doubleValue)
                .summaryStatistics();

        LOGGER.log(Level.INFO, "Statistics -> Min: {0}, Max: {1}, Average: {2}",
                new Object[]{stats.getMin(), stats.getMax(), stats.getAverage()});
    }
}