
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class DatabaseToJSONReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        String query = "SELECT * FROM your_table";
        String jsonFile = "report.json";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            generateJSONReport(rs, jsonFile);
            System.out.println("JSON report generated successfully.");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateJSONReport(ResultSet rs, String filePath) throws SQLException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()) {
            ObjectNode objNode = mapper.createObjectNode();
            for (int i = 1; i <= columnCount; i++) {
                objNode.put(metaData.getColumnName(i), rs.getString(i));
            }
            arrayNode.add(objNode);
        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), arrayNode);
    }
}


