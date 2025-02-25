import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";
        mergeCSVFiles(file1, file2, outputFile);
    }

    public static void mergeCSVFiles(String file1, String file2, String outputFile) {
        Map<Integer, String[]> studentData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0].trim());
                studentData.put(id, fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            bw.write("ID,Name,Age,Marks,Grade\n");
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0].trim());
                if (studentData.containsKey(id)) {
                    String[] studentInfo = studentData.get(id);
                    bw.write(String.join(

