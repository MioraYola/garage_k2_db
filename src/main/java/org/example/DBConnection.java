package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection getConnection() {
        try {
            String url = System.getenv("JDBC_URL");  // tout en majuscule
            String user = System.getenv("JDBC_USER");
            String password = System.getenv("JDBC_PASSWORD");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/garage_k2_db", "postgres", "raketa");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
