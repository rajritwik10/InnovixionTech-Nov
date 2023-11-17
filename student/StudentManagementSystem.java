package student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
    private String studentId;
    private String name;
    private Map<String, Double> grades; // Map of subject -> grade

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void addGrade(String subject, double grade) {
        grades.put(subject, grade);
    }

    public double getGPA() {
        if (grades.isEmpty()) return 0.0;

        double totalGradePoints = 0.0;
        for (double grade : grades.values()) {
            totalGradePoints += grade;
        }
        return (totalGradePoints / grades.size())%1000000007;
    }
}

class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String studentId) {
        students.removeIf(student -> student.getStudentId().equals(studentId));
    }

    public void recordGrade(String studentId, String subject, double grade) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.addGrade(subject, grade);
                break;
            }
        }
    }

    // Other methods for managing students
}

class ReportGenerator {
    public static void generateReport(Student student) {
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Student Name: " + student.getName());
        System.out.println("GPA: " + student.getGPA());
        // Additional report details
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Student student1 = new Student("1", "Alice");
        student1.addGrade("Math", 85.0);
        student1.addGrade("Physics", 78.0);
        student1.addGrade("chemistry", 89.0);
        student1.addGrade("History", 88.0);
        student1.addGrade("Geography", 79.0);
        student1.addGrade("Civics", 92.0);

        manager.addStudent(student1);

        Student student2 = new Student("2", "Bob");
        student2.addGrade("Math", 87.0);
        student2.addGrade("Physics", 79.0);
        student2.addGrade("chemistry", 98.0);
        student2.addGrade("History", 94.0);
        student2.addGrade("Geography", 95.0);
        student2.addGrade("Civics", 92.0);


        manager.addStudent(student2);

        ReportGenerator.generateReport(student1);
        ReportGenerator.generateReport(student2);
    }
}


