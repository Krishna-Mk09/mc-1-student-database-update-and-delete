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

public class DatabaseService {
    private static final String URL = "jdbc:mysql://localhost:3306/myschool";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Krishna@81433*";
    private Connection connection;

    public DatabaseService() {
        this.connection = null;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        return connection != null;
    }


}
