package com.practiceproblems.json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

public class ReadJsonExtractFields {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/output.json"));
            String brand = rootNode.get("brand").asText();
            String model = rootNode.get("model").asText();

            System.out.println("Name: " + brand);
            System.out.println("Email: " + model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}