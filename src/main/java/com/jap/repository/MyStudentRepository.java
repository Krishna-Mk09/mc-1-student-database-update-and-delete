/*
 * Author Name : M.Krishna.
 * Date: 16-09-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.jap.repository;

import com.jap.model.MyStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyStudentRepository {
    public boolean add(Connection connection, MyStudent mystudents) throws SQLException {
        // 1. write the query for inserting a new salesperson object into the `sales_person` table
        String insertQuery = "INSERT INTO `myschool`.`mystudent` " + "(`name`, `rollNumber`, `grade`,`totalMarks`) " + "VALUES (?, ?, ?, ?);";

        // 2. create a statement object
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // 3. set the values of the query parameters
            preparedStatement.setString(1, (mystudents.getName()));
            preparedStatement.setInt(2, (mystudents.getRollNumber()));
            preparedStatement.setString(3, (mystudents.getGrade()));
            preparedStatement.setInt(4, (mystudents.getTotalMarks()));

            // 4. execute the query
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }

        return numberOfRowsAffected > 0;
    }

}
