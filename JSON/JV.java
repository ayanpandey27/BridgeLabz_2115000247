
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import java.io.File;
import java.io.IOException;

public class EmailValidation {
    public static void main(String[] args) throws IOException, ProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Load JSON Schema
        JsonNode schemaNode = objectMapper.readTree(new File("schema.json"));
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode.toString());

        // Load JSON Data
        JsonNode jsonData = objectMapper.readTree("{\"email\": \"invalid-email\"}"); // Change to test

        // Validate JSON
        ProcessingReport report = schema.validate(jsonData);
        if (report.isSuccess()) {
            System.out.println("Valid JSON!");
        } else {
            System.out.println("Invalid JSON:");
            for (ProcessingMessage message : report) {
                System.out.println(message);
            }
        }
    }
}


