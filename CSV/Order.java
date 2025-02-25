import java.io.*;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<String[]> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                employees.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        employees.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

        System.out.println("Top 5 Highest-Paid Employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            String[] emp = employees.get(i);
            System.out.printf("ID: %s, Name: %s, Department: %s, Salary: %s%n", emp[0], emp[1], emp[2], emp[3]);
        }
    }
}

