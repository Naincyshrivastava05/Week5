package com.ioprogramming.advanceprogramming.CSVDataintoJavaObjects;

import java.io.*;
import java.util.*;

public class ConvertCSVToObjects {
    public static void main(String[] args) {
        String filePath = "src\\main\\resources\\students.csv"; // Ensure the file exists
        List<Students> students = readStudentsFromCSV(filePath);

        // Print the student list
        System.out.println("Students List:");
        students.forEach(System.out::println);
    }

    public static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    double marks = Double.parseDouble(data[3].trim());

                    students.add(new Students(id, name, age, marks));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }

        return students;
    }
}
