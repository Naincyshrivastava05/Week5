package handsonpractiseproblem;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateEmailJsonTest {

    @Test
    public void testValidEmailJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(new File("src/main/resources/example.json"));
            JsonNode schemaNode = JsonLoader.fromFile(new File("src/main/resources/emailSchema.json"));

            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            ProcessingReport report = schema.validate(jsonData);

            assertTrue(report.isSuccess(), "Email validation failed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}