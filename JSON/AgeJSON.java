
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.File;

public class FilterUsersByAge {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File("users.json"));

        ArrayNode filteredArray = objectMapper.createArrayNode();

        for (JsonNode node : rootNode) {
            if (node.get("age").asInt() > 25) {
                filteredArray.add(node);
            }
        }

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredArray));
    }
}


