import java.util.ArrayList;
import java.util.List;

// Class to represent a Student
class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a list of Student objects
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 80.0));
        students.add(new Student("Bob", 65.0));
        students.add(new Student("Charlie", 90.0));
        students.add(new Student("David", 70.0));
        students.add(new Student("Eve", 85.0));
        students.add(new Student("Frank", 78.0));
        students.add(new Student("Grace", 92.0));
        students.add(new Student("Henry", 72.0));

        System.out.println("Initial list of students:");
        students.forEach(System.out::println);

        // Use Stream API to filter students with marks above 75, sort them by marks, and display their names
        System.out.println("\nStudents with marks above 75, sorted by marks:");
        students.stream()
                .filter(student -> student.getMarks() > 75) // Filter students with marks > 75
                .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks())) // Sort in descending order of marks
                .forEach(student -> System.out.println(student.getName() + " - " + student.getMarks())); // Display student names and marks
        
        // Collect the names of the filtered and sorted students into a new list.
        List<String> topStudentsNames = students.stream()
                .filter(student -> student.getMarks() > 75)
                .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()))
                .map(Student::getName) // Extract the name from each Student object
                .toList(); // Collect the names into a List
                
        System.out.println("\nTop Students Names: " + topStudentsNames);
    }
}

