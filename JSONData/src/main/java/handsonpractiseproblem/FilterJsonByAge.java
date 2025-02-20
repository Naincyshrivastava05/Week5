package handsonpractiseproblem;

package com.handsonpracticeproblems.json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.io.*;

public class FilterJsonByAge {
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