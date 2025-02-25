import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("201,John Doe,IT,75000\n");
            writer.append("202,Jane Smith,HR,68000\n");
            writer.append("203,Michael Brown,Finance,72000\n");
            writer.append("204,Emily Davis,Marketing,70000\n");
            writer.append("205,David Wilson,Operations,73000\n");

            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

