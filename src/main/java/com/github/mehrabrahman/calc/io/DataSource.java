package com.github.mehrabrahman.calc.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static String url;
    private static String user;
    private static String password;

    static {
        url = System.getProperty("database.url", "jdbc:postgresql://localhost:5432/opsdb");
        user = System.getProperty("database.username", "opsdb");
        password = System.getProperty("database.password", "opsdb");
    }
 
    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}