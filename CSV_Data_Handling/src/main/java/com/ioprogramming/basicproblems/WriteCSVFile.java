package com.ioprogramming.basicproblems;

import java.io.*;

public class WriteCSVFile {


    public static void writeCSV(String filePath) {
        String[] employees = {
                "101,Naincy Shrivastava,IT,60000",
                "102,Sanjh Patel,HR,55000",
                "103,Vishakha,Finance,58000",
                "104,Bhumika,Marketing,62000",
                "105,Raksha,Sales,59000"
        };

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String employee : employees) {
                bw.write(employee);
                bw.newLine();
            }
            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String filePath = "src\\main\\resources\\employees.csv"; // CSV file path
        writeCSV(filePath);
    }
}
