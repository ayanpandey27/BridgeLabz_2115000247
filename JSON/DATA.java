
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.*;

public class CSVToJSONConverter {
    public static void main(String[] args) throws IOException {
        String csvFile = "data.csv";
        String jsonFile = "data.json";

        List<Map<String, String>> data = readCSV(csvFile);
        writeJSON(data, jsonFile);

        System.out.println("CSV converted to JSON successfully.");
    }

    private static List<Map<String, String>> readCSV(String filePath) throws IOException {
        List<Map<String, String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String[] headers = br.readLine().split(",");
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> record = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    record.put(headers[i], values[i]);
                }
                records.add(record);
            }
        }
        return records;
    }

    private static void writeJSON(List<Map<String, String>> data, String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        
        for (Map<String, String> record : data) {
            ObjectNode objNode = mapper.createObjectNode();
            record.forEach(objNode::put);
            arrayNode.add(objNode);
        }
        
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), arrayNode);
    }
}


