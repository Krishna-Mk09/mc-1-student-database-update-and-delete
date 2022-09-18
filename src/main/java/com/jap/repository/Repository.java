package com.jap.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    boolean add(Connection connection, T object) throws SQLException;

    List<T> getAll(Connection connection) throws SQLException;

    boolean updateRollNumbers(Connection connection, int rollNumber, int totalMarks) throws SQLException;

    boolean deleteByRollNumber(Connection connection, int rollNumber) throws SQLException;
}
