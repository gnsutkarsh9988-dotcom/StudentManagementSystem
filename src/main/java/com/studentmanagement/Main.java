package com.studentmanagement;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Student Management System Started!");

        StudentDAO dao = new StudentDAO();

        // Add a new student
        Student newStudent = new Student(
                0,
                "Rohit Kumar",
                "rohit@gmail.com",
                "BCA",
                23
        );

        dao.addStudent(newStudent);

        // Get all students
        List<Student> students = dao.getAllStudents();

        System.out.println("\n--- Student List ---");

        for (Student student : students) {
            System.out.println(
                    student.getId() + " | " +
                    student.getName() + " | " +
                    student.getEmail() + " | " +
                    student.getCourse() + " | " +
                    student.getAge()
            );
        }
        // Update student by ID
System.out.println("\nUpdating student with ID 4...");

Student updatedStudent = new Student(
    4,
    "Rohit Kumar Updated",
    "rohitupdated@gmail.com",
    "BCA",
    24
);

dao.updateStudent(updatedStudent);

// Show updated student list
List<Student> updatedStudents = dao.getAllStudents();

System.out.println("\n--- Updated Student List ---");

for (Student student : updatedStudents) {
    System.out.println(
        student.getId() + " | " +
        student.getName() + " | " +
        student.getEmail() + " | " +
        student.getCourse() + " | " +
        student.getAge()
    );
}
    }
}