import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "large_data.csv";
        readLargeCSV(filePath, 100);
    }

    public static void readLargeCSV(String filePath, int chunkSize) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                count++;
                if (count % chunkSize == 0) {
                    System.out.println("Processed: " + count + " records");
                }
            }
            System.out.println("Total records processed: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

