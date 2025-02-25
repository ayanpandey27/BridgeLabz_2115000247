import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFilePath = "employees.csv";
        String outputFilePath = "updated_employees.csv";
        List<String[]> updatedRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (isHeader) {
                    isHeader = false;
                } else if (values[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(values[3]) * 1.10;
                    values[3] = String.format("%.2f", salary);
                }

                updatedRecords.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String[] record : updatedRecords) {
                bw.write(String.join(",", record));
                bw.newLine();
            }
            System.out.println("Updated CSV saved as: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

