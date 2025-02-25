import java.io.*;
import java.sql.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        writeEmployeeDataToCSV("employees.csv");
    }

    public static void writeEmployeeDataToCSV(String filePath) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            bw.write("Employee ID,Name,Department,Salary\n");
            ResultSet rs = stmt.executeQuery("SELECT id, name, department, salary FROM employees");
            while (rs.next()) {
                bw.write(rs.getInt("id") + "," + rs.getString("name") + "," + 
                         rs.getString("department") + "," + rs.getDouble("salary") + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

