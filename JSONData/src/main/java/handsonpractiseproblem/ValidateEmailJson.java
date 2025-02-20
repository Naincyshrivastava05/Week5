package handsonpractiseproblem;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.File;

public class ValidateEmailJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(new File("src/main/resources/example.json"));
            JsonNode schemaNode = JsonLoader.fromFile(new File("src/main/resources/emailSchema.json"));

            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            ProcessingReport report = schema.validate(jsonData);

            if (report.isSuccess()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("Invalid JSON! Errors:");
                report.forEach(msg -> System.out.println(msg));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}