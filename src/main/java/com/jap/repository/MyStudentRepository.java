/*
 * Author Name : M.Krishna.
 * Date: 16-09-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.jap.repository;

import com.jap.model.MyStudent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<MyStudent> getAll(Connection connection) throws SQLException {
        // 1. write the query for selecting all the salesperson objects from the `sales_person` table
        String readQuery = "SELECT * FROM `myschool`.`mystudent`;";
        List<MyStudent> myStudent = new ArrayList<>();
        // 2. create a statement object
        try (Statement statement = connection.createStatement()) {
            // 3. execute the query
            ResultSet myStudentResultSet = statement.executeQuery(readQuery);
            // 4. iterate over the result set and create a list of salesperson objects
            while (myStudentResultSet.next()) {
                // 5. fetch the values of the current row from the result set
                String name = myStudentResultSet.getString("name");
                int rollNumber = myStudentResultSet.getInt("rollNumber");
                String city = myStudentResultSet.getString("grades");
                int totalMarks = myStudentResultSet.getInt("totalMarks");
                // 6. create a salesperson object using the values fetched from the result set
                MyStudent myStudent1 = new MyStudent(name, rollNumber, city, totalMarks);
                // 7. add the salesperson object to the list
                myStudent.add(myStudent1);
            }
        }
        return myStudent;
    }

    public boolean updateRollNumbers(Connection connection, int rollNumber, int totalMarks) throws SQLException {
        String updateQuery = "UPDATE `myschool`.`mystudent` SET `rollNumber` = ? WHERE (`totalMarks` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, rollNumber);
            preparedStatement.setInt(2, totalMarks);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    public boolean deleteByRollNumber(Connection connection, int rollNumber) throws SQLException {
        String deleteQuery = "DELETE FROM `myschool`.`mystudent` WHERE (`rollNumber` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, rollNumber);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }
}
