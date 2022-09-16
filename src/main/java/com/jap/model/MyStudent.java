/*
 * Author Name : M.Krishna.
 * Date: 16-09-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.jap.model;

import java.util.Objects;

public class MyStudent {
    private String name;
    private int rollNumber;
    private String grade;
    private int totalMarks;

    public MyStudent() {
    }

    public MyStudent(String name, int rollNumber, String grade, int totalMarks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.totalMarks = totalMarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyStudent myStudent = (MyStudent) o;

        if (rollNumber != myStudent.rollNumber) return false;
        if (totalMarks != myStudent.totalMarks) return false;
        if (!Objects.equals(name, myStudent.name)) return false;
        return Objects.equals(grade, myStudent.grade);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + rollNumber;
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + totalMarks;
        return result;
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade='" + grade + '\'' +
                ", totalMarks=" + totalMarks +
                '}';
    }
}
