import java.io.*;

public class DecryptCSVReader {
    public static void main(String[] args) {
        String filePath = "employees_encrypted.csv";
        readDecryptedCSV(filePath);
    }

    public static void readDecryptedCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (!row[0].equals("ID")) { 
                    row[2] = AESEncryption.decrypt(row[2]); 
                    row[3] = AESEncryption.decrypt(row[3]);
                }
                System.out.println(String.join(", ", row));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

