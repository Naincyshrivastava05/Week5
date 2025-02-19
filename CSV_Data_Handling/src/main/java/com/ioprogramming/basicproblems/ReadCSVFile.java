package com.ioprogramming.basicproblems;

import java.io.*;

public class ReadCSVFile {


    public static void readCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("ID | Name | Age | Marks");
            System.out.println("-------------------------");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    System.out.printf("%s | %s | %s | %s%n", data[0], data[1], data[2], data[3]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String filePath = "src\\main\\resources\\Student.csv"; // Update with the correct file path
        readCSV(filePath);
    }
}
