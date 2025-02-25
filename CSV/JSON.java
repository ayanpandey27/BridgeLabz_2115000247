import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;
import java.util.*;

public class JSONCSVConverter {
    public static void main(String[] args) throws IOException {
        convertJsonToCsv("students.json", "students.csv");
        convertCsvToJson("students.csv", "students.json");
    }

    public static void convertJsonToCsv(String jsonFile, String csvFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> data = mapper.readValue(new File(jsonFile), new TypeReference<>() {});

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            bw.write(String.join(",", data.get(0).keySet()) + "\n");
            for (Map<String, Object> row : data) {
                bw.write(String.join(",", row.values().toString()) + "\n");
            }
        }
    }

    public static void convertCsvToJson(String csvFile, String jsonFile) throws IOException {
        List<Map<String, String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String[] headers = br.readLine().split(",");
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> obj = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], values[i]);
                }
                data.add(obj);
            }
        }
        new ObjectMapper().writeValue(new File(jsonFile), data);
    }
}

