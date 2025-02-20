package practiseproblems.javaobjectintojson;

package com.practiceproblems.json.javaobjectintojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

public class ConvertObjectToJson {
    public static void main(String[] args) {
        try {
            Car car = new Car("BMW", "M-5", 2024);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("src\\main\\resources\\output.json"), car);
            System.out.println("JSON file created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}