package com.ioprogramming.advanceprogramming;

import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "large_data.csv"; // Replace with actual large file
        readCSVInChunks(filePath, 100);
    }

    public static void readCSVInChunks(String filePath, int chunkSize) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header
                    continue;
                }

                // Process the line (print or store)
                count++;

                // Display batch processed count
                if (count % chunkSize == 0) {
                    System.out.println("Processed " + count + " records...");
                }
            }
            System.out.println("Total records processed: " + count);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
