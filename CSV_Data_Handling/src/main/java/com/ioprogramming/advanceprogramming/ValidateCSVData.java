package com.ioprogramming.advanceprogramming;

import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "src\\main\\resources\\employees.csv"; // Update with your file path
        validateCSV(filePath);
    }

    public static void validateCSV(String filePath) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            System.out.println("Validating CSV data...");
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }
                String[] data = line.split(",");
                if (data.length < 5) { // Ensure there are enough columns
                    System.out.println("ERROR: Invalid record (missing columns): " + line);
                    continue;
                }

                String email = data[3].trim();  // Assuming email is the 4th column
                String phone = data[4].trim();  // Assuming phone number is the 5th column

                boolean isValidEmail = emailPattern.matcher(email).matches();
                boolean isValidPhone = phonePattern.matcher(phone).matches();

                if (!isValidEmail || !isValidPhone) {
                    System.out.println("ERROR: Invalid record: " + line);
                    if (!isValidEmail) System.out.println("  → Invalid Email: " + email);
                    if (!isValidPhone) System.out.println("  → Invalid Phone: " + phone);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
