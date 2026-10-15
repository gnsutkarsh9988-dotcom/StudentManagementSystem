package com.studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/student_management";

    private static final String USER = "root";

    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {

        try {
            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully!");

            return connection;

        } catch (SQLException e) {

            System.out.println("Database Connection Failed!");
            System.out.println(e.getMessage());

            return null;
        }
    }
}