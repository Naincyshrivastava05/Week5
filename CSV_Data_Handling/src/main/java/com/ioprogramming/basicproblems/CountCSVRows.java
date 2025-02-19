package com.ioprogramming.basicproblems;

import java.io.*;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "src\\main\\resources\\employees.csv";
        int rowCount = countCSVRows(filePath);
        System.out.println("Number of records: " + rowCount);
    }

    public static int countCSVRows(String filePath) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }
                count++;
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return count;
    }
}
