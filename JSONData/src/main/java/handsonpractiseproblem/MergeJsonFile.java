package handsonpractiseproblem;

package com.handsonpracticeproblems.json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import java.io.File;

public class MergeJsonFile {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode1 = objectMapper.readTree(new File("src/main/resources/example.json"));
            JsonNode jsonNode2 = objectMapper.readTree(new File("src/main/resources/example1.json"));

            JSONObject json1 = new JSONObject(jsonNode1.toString());
            JSONObject json2 = new JSONObject(jsonNode2.toString());

            for (String key : json2.keySet()) {
                json1.put(key, json2.get(key));
            }

            System.out.println("Merged JSON: " + json1.toString(4));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}