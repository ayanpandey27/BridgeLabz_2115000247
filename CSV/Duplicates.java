import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "students.csv";
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Set<String> uniqueIds = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String id = line.split(",")[0].trim();
                if (!uniqueIds.add(id)) {
                    System.out.println("Duplicate record: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

