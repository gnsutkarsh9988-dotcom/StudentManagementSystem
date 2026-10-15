package com.studentmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // CREATE - Add Student
    public void addStudent(Student student) {

        String sql = "INSERT INTO students (name, email, course, age) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getCourse());
            statement.setInt(4, student.getAge());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // READ - Get All Students
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                Student student = new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("course"),
                    resultSet.getInt("age")
                );

                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Error getting students: " + e.getMessage());
        }

        return students;
    }

    // READ - Get Student By ID
    public Student getStudentById(int id) {

        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                return new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("course"),
                    resultSet.getInt("age")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error finding student: " + e.getMessage());
        }

        return null;
    }

    // UPDATE - Update Student
    public void updateStudent(Student student) {

        String sql = "UPDATE students SET name = ?, email = ?, course = ?, age = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getCourse());
            statement.setInt(4, student.getAge());
            statement.setInt(5, student.getId());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    // DELETE - Delete Student
    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}