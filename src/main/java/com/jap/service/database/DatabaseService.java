/*
 * Author Name : M.Krishna.
 * Date: 16-09-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.jap.service.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * It's a class that connects to the database and returns the connection object
 */
public class DatabaseService {
    // It's a connection string that is used to connect to the database.
    private static final String URL = "jdbc:mysql://localhost:3306/myschool";
    // It's a constant variable that is used to store the username of the database.
    private static final String USERNAME = "root";
    // It's a constant variable that is used to store the password of the database.
    private static final String PASSWORD = "Krishna@81433*";
    // It's a constructor that is used to initialize the connection object.
    // It's a variable that is used to store the connection object.
    private Connection connection;

    // It's a constructor that is used to initialize the connection object.
    public DatabaseService() {
        this.connection = null;
    }

    /**
     * This function returns the connection.
     *
     * @return The connection object.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * > This function connects to the database using the URL, USERNAME, and PASSWORD variables
     *
     * @return A boolean value.
     */
    public boolean connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection != null;
    }

    /**
     * If the connection is not null, print a green message saying that the database is connected. Otherwise, print a red
     * error message saying that the database is not connected
     */
    public void printConnectStatus() {
        if (connection != null) {
            System.out.println("\u001B[32m Database is connected. \u001B[0m");
        } else {
            System.err.println("Database not connected");
        }
    }
}
