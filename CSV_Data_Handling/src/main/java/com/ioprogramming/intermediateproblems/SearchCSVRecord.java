package com.ioprogramming.intermediateproblems;

import java.io.*;

public class SearchCSVRecord {
    public static void main(String[] args) {
        String filePath = "src\\main\\resources\\employees.csv";
        String searchName = "Naincy Shrivastava"; // Name to search for
        searchEmployee(filePath, searchName);
    }

    public static void searchEmployee(String filePath, String name) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 4 && data[1].trim().equalsIgnoreCase(name)) {
                    System.out.printf("Employee: %s, Department: %s, Salary: %s%n", data[1], data[2], data[3]);
                    return;
                }
            }
            System.out.println("Employee not found.");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
