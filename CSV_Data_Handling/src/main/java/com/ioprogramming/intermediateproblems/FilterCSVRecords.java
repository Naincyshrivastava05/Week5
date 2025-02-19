package com.ioprogramming.intermediateproblems;

import java.io.*;

public class FilterCSVRecords {
    public static void main(String[] args) {
        String filePath = "src\\main\\resources\\Student.csv"; // Update with the correct file path
        filterHighScorers(filePath);
    }

    public static void filterHighScorers(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            System.out.println("ID | Name | Age | Marks");
            System.out.println("-------------------------");
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 4) {
                    int marks = Integer.parseInt(data[3].trim());
                    if (marks > 80) {
                        System.out.printf("%s | %s | %s | %s%n", data[0], data[1], data[2], data[3]);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
