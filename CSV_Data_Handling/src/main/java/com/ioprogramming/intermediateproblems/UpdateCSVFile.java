package com.ioprogramming.intermediateproblems;
import java.io.*;

public class UpdateCSVFile {
    public static void main(String[] args) {
        String inputFile = "src\\main\\resources\\employees.csv"; // Original file
        String outputFile = "updated_employees.csv"; // Updated file

        updateSalaries(inputFile, outputFile);
    }

    public static void updateSalaries(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    bw.write(line + "\n"); // Write header as is
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 4) {
                    String department = data[2].trim();
                    double salary = Double.parseDouble(data[3].trim());

                    // Increase salary by 10% for IT department employees
                    if (department.equalsIgnoreCase("IT")) {
                        salary *= 1.10;
                    }

                    // Write updated record to new file
                    bw.write(data[0] + "," + data[1] + "," + data[2] + "," + String.format("%.2f", salary) + "\n");
                }
            }

            System.out.println("Updated salaries have been saved to " + outputFile);

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
