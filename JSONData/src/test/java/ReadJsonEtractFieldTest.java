package com.practiceproblems.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class ReadJsonEtractFieldTest {
    @Test
    void readData(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/output.json"));
            String brand = rootNode.get("brand").asText();
            String model = rootNode.get("model").asText();

            assertEquals("BMW",brand);
            assertEquals("M-5",model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}