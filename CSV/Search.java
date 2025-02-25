import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String searchName = scanner.nextLine();
        scanner.close();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] values = line.split(",");
                if (values[1].equalsIgnoreCase(searchName)) {
                    System.out.printf("Department: %s, Salary: %s%n", values[2], values[3]);
                    return;
                }
            }

            System.out.println("Employee not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

