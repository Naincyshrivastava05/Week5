package practiseproblems;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ParseAndFilterJsonByAgeTest {

    @Test
    void testFilterAgeGreaterThan25() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/people.json"));

        List<JsonNode> filteredRecords = new ArrayList<>();
        for (JsonNode node : rootNode) {
            if (node.has("age") && node.get("age").asInt() > 25) {
                filteredRecords.add(node);
            }
        }
        assertEquals(2, filteredRecords.size(), "Expected 2 records with age > 25");
        assertEquals("Rahul", filteredRecords.get(0).get("name").asText());
        assertEquals("Priya", filteredRecords.get(1).get("name").asText());
    }
}