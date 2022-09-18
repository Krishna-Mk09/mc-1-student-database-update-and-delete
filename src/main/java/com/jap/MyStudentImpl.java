/*
 * Author Name : M.Krishna.
 * Date: 17-09-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.jap;

import com.jap.model.MyStudent;
import com.jap.repository.MyStudentRepository;
import com.jap.service.database.DatabaseService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MyStudentImpl {
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        int choice;
        do {
            System.out.println(" Welcome To The MyStudent DataBase Management System");
            System.out.println("------------------------------------------------------");
            System.out.println("1. Add a new student");
            System.out.println("2. View  all the student");
            System.out.println("3. Update the student by rollNumber ");
            System.out.println("4. Delete a student by rollNumber");
            System.out.println("5. EXIT");
            System.out.println("-------------------------------------------------------");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            try {
                databaseService.connect();
                MyStudentRepository myStudentRepository = new MyStudentRepository();
                Connection connection = databaseService.getConnection();
                switch (choice) {
                    case 1:
                        System.out.println("Add a new student");
                        System.out.println("Enter the student name");
                        String studentName = scanner.next();
                        System.out.println("Enter the student rolNumber");
                        int rollNumber = scanner.nextInt();
                        System.out.println("Enter students grade");
                        String grade = scanner.next();
                        System.out.println("Enter students total marks");
                        int totalMarks = scanner.nextInt();
                        MyStudent myStudent = new MyStudent(studentName, rollNumber, grade, totalMarks);
                        myStudentRepository.add(connection, myStudent);
                        break;
                    case 2: {
                        System.out.println("View all students");
                        myStudentRepository.getAll(connection).forEach(System.out::println);
                    }
                    break;
                    case 3: {
                        System.out.println("update a students by rollNumber ");
                        System.out.println("Enter the Students's rollNumber: ");
                        int rollNumber1 = scanner.nextInt();
                        System.out.println("enter total marks");
                        int totalMarks1 = scanner.nextInt();
                        myStudentRepository.updateRollNumbers(connection, rollNumber1, totalMarks1);
                    }
                    break;
                    case 4: {
                        System.out.println("Delete a Student by rollNumber");
                        System.out.println("Enter the Student3 rollNumber: ");
                        rollNumber = scanner.nextInt();
                        myStudentRepository.deleteByRollNumber(connection, rollNumber);
                        break;
                    }
                    case 5: {
                        System.out.println("EXIT");
                        break;
                    }
                    default:
                        System.err.println("invalid Choice");
                }
            } catch (ClassNotFoundException | SQLException exception) {
                System.err.println("Error while connecting to database");
                exception.printStackTrace();
                choice = 7;
            } finally {
                {
                    databaseService.printConnectStatus();
                }
            }
        } while (choice != 7);
    }
}