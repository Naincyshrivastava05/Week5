package com.practiceproblems.json;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class ConvertObjectToJsonTest {

    @Test
    void testJsonFileCreated() {
        File jsonFile = new File("src/main/resources/output.json");
        assertTrue(jsonFile.exists());
        assertTrue(jsonFile.length() > 0);
    }
}