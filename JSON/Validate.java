
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ValidateJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File("data.json"));

        if (rootNode.has("name") && rootNode.has("email") && rootNode.has("age")) {
            System.out.println("Valid JSON structure.");
        } else {
            System.out.println("Invalid JSON: Missing required fields.");
        }
    }
}


