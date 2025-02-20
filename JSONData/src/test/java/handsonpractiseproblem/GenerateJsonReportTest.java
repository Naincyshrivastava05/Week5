package handsonpractiseproblem;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class GenerateJsonReportTest {

    @Test
    void testJsonReportGenerated() {
        File jsonFile = new File("src/main/resources/report.json");

        assertTrue(jsonFile.exists(), "JSON report file should be generated");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(jsonFile);

            assertTrue(jsonData.isArray(), "JSON report should be an array");

            assertTrue(jsonData.size() > 0, "JSON report should have at least one employee record");

            JsonNode firstRecord = jsonData.get(0);
            assertNotNull(firstRecord.get("emp_id"), "emp_id should be present");
            assertNotNull(firstRecord.get("name"), "name should be present");
            assertNotNull(firstRecord.get("department"), "department should be present");
            assertNotNull(firstRecord.get("salary"), "salary should be present");

        } catch (Exception e) {
            fail("Exception while reading JSON file: " + e.getMessage());
        }
    }
}
