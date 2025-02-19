package com.ioprogramming.advanceprogramming;

import org.json.*;
import java.io.*;

public class JsonCSVConverter {

    public static void main(String[] args) {
        convertJSONToCSV("students.json", "students.csv");
        convertCSVToJSON("students.csv", "students.json");
    }

    private static void convertCSVToJSON(String s, String s1) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

            JSONArray students = new JSONArray(new JSONTokener(br));
            bw.write("ID,Name,Age,Marks\n");
            for (Object obj : students) {
                JSONObject student = (JSONObject) obj;
                bw.write(student.getInt("ID") + "," +
                        student.getString("Name") + "," +
                        student.getInt("Age") + "," +
                        student.getDouble("Marks") + "\n");
            }
            System.out.println("CSV file created: " + csvFile);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void convertJSONToCSV(String jsonFile, String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

            JSONArray students = new JSONArray(new JSONTokener(br));
            bw.write("ID,Name,Age,Marks\n");
            for (Object obj : students) {
                JSONObject student = (JSONObject) obj;
                bw.write(student.getInt("ID") + "," +
                        student.getString("Name") + "," +
                        student.getInt("Age") + "," +
                        student.getDouble("Marks") + "\n");
            }
            System.out.println("CSV file created: " + csvFile);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
