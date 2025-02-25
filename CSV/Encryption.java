import java.io.*;
import java.util.*;

public class EncryptCSVWriter {
    public static void main(String[] args) {
        String filePath = "employees_encrypted.csv";
        List<String[]> data = Arrays.asList(
            new String[]{"ID", "Name", "Email", "Salary"},
            new String[]{"1", "Alice", "alice@example.com", "5000"},
            new String[]{"2", "Bob", "bob@example.com", "6000"}
        );
        writeEncryptedCSV(filePath, data);
    }

    public static void writeEncryptedCSV(String filePath, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                if (!row[0].equals("ID")) { 
                    row[2] = AESEncryption.encrypt(row[2]); 
                    row[3] = AESEncryption.encrypt(row[3]);
                }
                bw.write(String.join(",", row) + "\n");
            }
            System.out.println("Encrypted CSV file written successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


