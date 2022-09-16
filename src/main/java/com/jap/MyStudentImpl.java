/*
 * Author Name : M.Krishna.
 * Date: 17-09-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.jap;

import com.jap.repository.MyStudentRepository;
import com.jap.service.database.DatabaseService;

import java.sql.Connection;
import java.sql.SQLException;

public class MyStudentImpl {
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();

        try {
            databaseService.connect();
            MyStudentRepository myStudentRepository = new MyStudentRepository();
            Connection connection = databaseService.getConnection();
            myStudentRepository.getAll(connection).forEach(System.out::println);
        } catch (ClassNotFoundException | SQLException exception) {
            System.err.println("Error while connecting to database");
            exception.printStackTrace();
        } finally {
            {
                databaseService.printConnectStatus();
            }
        }
    }
}