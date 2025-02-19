package com.ioprogramming.advanceprogramming;

import java.io.*;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "src\\main\\resources\\students.csv";
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                if (!uniqueIds.add(data[0])) {
                    duplicates.add(line);
                }
            }
            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records:");
                duplicates.forEach(System.out::println);
            }
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
