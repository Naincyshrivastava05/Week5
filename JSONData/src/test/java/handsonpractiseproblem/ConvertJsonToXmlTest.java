package handsonpractiseproblem;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConvertJsonToXmlTest {

    @Test
    public void testJsonToXmlConversion() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/example.json"));

        JSONObject jsonObject = new JSONObject(jsonNode.toString());
        String xmlData = XML.toString(jsonObject, "root");

        assertTrue(xmlData.contains("<root>"));
        assertTrue(xmlData.contains("<name>"));
        assertTrue(xmlData.contains("<name>Abhishek Kumar</name>"));
        assertTrue(xmlData.contains("<email>abhishek@example.com</email>"));
    }
}