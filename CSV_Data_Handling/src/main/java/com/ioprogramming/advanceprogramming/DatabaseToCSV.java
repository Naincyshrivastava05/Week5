package com.ioprogramming.advanceprogramming;

import java.io.*;
import java.sql.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "naincy@123";
        String outputFile = "employees.csv";

        writeEmployeesToCSV(url, user, password, outputFile);
    }

    public static void writeEmployeesToCSV(String url, String user, String password, String outputFile) {
        String query = "SELECT EmployeeID, Name, Department, Salary FROM Employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            writer.write("EmployeeID,Name,Department,Salary\n");
            while (rs.next()) {
                writer.write(rs.getInt("EmployeeID") + "," +
                        rs.getString("Name") + "," +
                        rs.getString("Department") + "," +
                        rs.getDouble("Salary") + "\n");
            }
            System.out.println("CSV file created: " + outputFile);
        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
