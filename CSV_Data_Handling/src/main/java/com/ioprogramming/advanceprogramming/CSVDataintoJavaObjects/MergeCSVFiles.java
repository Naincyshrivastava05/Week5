package com.ioprogramming.advanceprogramming.CSVDataintoJavaObjects;

import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "src\\main\\resources\\students1.csv"; // Contains ID, Name, Age
        String file2 = "src\\main\\resources\\students2.csv"; // Contains ID, Marks, Grade
        String outputFile = "merged_students.csv"; // Output file

        mergeCSVFiles(file1, file2, outputFile);
    }

    public static void mergeCSVFiles(String file1, String file2, String outputFile) {
        Map<String, String[]> studentMap = new HashMap<>();

        // Read first CSV file (ID, Name, Age)
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 3) {
                    studentMap.put(data[0], new String[]{data[1], data[2], "", ""});
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file1: " + e.getMessage());
        }

        // Read second CSV file (ID, Marks, Grade)
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 3 && studentMap.containsKey(data[0])) {
                    studentMap.get(data[0])[2] = data[1]; // Marks
                    studentMap.get(data[0])[3] = data[2]; // Grade
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file2: " + e.getMessage());
        }

        // Write merged data to a new CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n"); // Header
            for (Map.Entry<String, String[]> entry : studentMap.entrySet()) {
                String id = entry.getKey();
                String[] details = entry.getValue();
                bw.write(id + "," + details[0] + "," + details[1] + "," + details[2] + "," + details[3] + "\n");
            }
            System.out.println("Merged CSV file created successfully: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing output file: " + e.getMessage());
        }
    }
}