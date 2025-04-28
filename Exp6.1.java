import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Class to represent an Employee
class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a list of Employee objects
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000.0));
        employees.add(new Employee("Bob", 25, 60000.0));
        employees.add(new Employee("Charlie", 35, 70000.0));
        employees.add(new Employee("David", 25, 55000.0));
        employees.add(new Employee("Eve", 30, 48000.0));

        System.out.println("Initial list of employees:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Sort by name using a lambda expression
        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println("\nSorted by name:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Sort by age using a lambda expression
        Collections.sort(employees, (e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println("\nSorted by age:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Sort by salary using a lambda expression
        Collections.sort(employees, (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("\nSorted by salary:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        
        // Example of using comparing and thenComparing for multiple conditions
        System.out.println("\nSorted by age, then by name:");
        employees.sort(
            java.util.Comparator.comparing(Employee::getAge) // First sort by age
            .thenComparing(Employee::getName)       // Then sort by name
        );
         for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}

