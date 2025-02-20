package practiseproblems;

package com.practiceproblems.json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class ParseAndFilterJsonByAge {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/people.json"));

            List<JsonNode> filteredRecords = new ArrayList<>();
            for (JsonNode node : rootNode) {
                if (node.has("age") && node.get("age").asInt() > 25) {
                    filteredRecords.add(node);
                }
            }

            System.out.println(filteredRecords);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}