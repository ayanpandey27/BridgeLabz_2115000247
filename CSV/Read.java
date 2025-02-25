import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) { 
                    isHeader = false;
                    continue;
                }

                String[] values = line.split(",");
                System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %s%n", 
                                  values[0], values[1], values[2], values[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

