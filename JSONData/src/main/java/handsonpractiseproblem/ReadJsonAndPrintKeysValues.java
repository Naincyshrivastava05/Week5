package handsonpractiseproblem;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

public class ReadJsonAndPrintKeysValues {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/example.json"));

            rootNode.fields().forEachRemaining(entry ->
                    System.out.println(entry.getKey() + " : " + entry.getValue().asText())
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}