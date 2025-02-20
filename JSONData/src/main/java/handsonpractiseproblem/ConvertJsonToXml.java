package handsonpractiseproblem;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;
import java.io.File;

public class ConvertJsonToXml {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/example.json"));

            JSONObject jsonObject = new JSONObject(jsonNode.toString());

            String xmlData = XML.toString(jsonObject, "root");

            System.out.println("Converted XML\n" + xmlData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}