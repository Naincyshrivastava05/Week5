package com.ioprogramming.intermediateproblems;
import java.io.*;
import java.util.*;

public class SortCSVRecords {
    public static void main(String[] args) {
        String filePath = "src\\main\\resources\\employees.csv"; // Input CSV file
        sortEmployeesBySalary(filePath);
    }

    public static void sortEmployeesBySalary(String filePath) {
        List<String[]> employeeRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            String header = "";

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    header = line; // Store header
                    isHeader = false;
                    continue;
                }
                employeeRecords.add(line.split(","));
            }

            // Sort by salary in descending order
            employeeRecords.sort((a, b) -> Double.compare(Double.parseDouble(b[3].trim()), Double.parseDouble(a[3].trim())));

            // Print the top 5 highest-paid employees
            System.out.println(header);
            System.out.println("-------------------------------");
            for (int i = 0; i < Math.min(5, employeeRecords.size()); i++) {
                System.out.println(String.join(",", employeeRecords.get(i)));
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
