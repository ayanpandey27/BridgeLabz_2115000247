import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "students.csv"; 
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) { 
                    isHeader = false; 
                    continue; 
                }
                rowCount++;
            }

            System.out.println("Total Records (excluding header): " + rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

