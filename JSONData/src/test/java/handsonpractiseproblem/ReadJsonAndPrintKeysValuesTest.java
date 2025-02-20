package handsonpractiseproblem;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadJsonAndPrintKeysValuesTest {

    @Test
    public void testReadJsonAndPrintKeysValues() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/example.json"));

            Set<String> expectedKeys = new HashSet<>();
            expectedKeys.add("name");
            expectedKeys.add("email");
            expectedKeys.add("age");

            Set<String> actualKeys = new HashSet<>();
            rootNode.fields().forEachRemaining(entry -> actualKeys.add(entry.getKey()));

            assertTrue(actualKeys.containsAll(expectedKeys));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}