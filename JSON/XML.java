
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        // Read JSON from file
        JsonNode jsonNode = jsonMapper.readTree(new File("data.json"));

        // Convert JSON to XML
        String xmlOutput = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        System.out.println(xmlOutput);
    }
}


