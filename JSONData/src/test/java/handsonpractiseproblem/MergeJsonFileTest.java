package handsonpractiseproblem;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeJsonFileTest {

    @Test
    public void testMergeJsonFiles() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode1 = objectMapper.readTree(new File("src/main/resources/example.json"));
        JsonNode jsonNode2 = objectMapper.readTree(new File("src/main/resources/example1.json"));

        JSONObject json1 = new JSONObject(jsonNode1.toString());
        JSONObject json2 = new JSONObject(jsonNode2.toString());

        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        assertTrue(json1.has("name"));
        assertTrue(json1.has("email"));
        assertTrue(json1.has("age"));
        assertTrue(json1.has("city"));
    }
}