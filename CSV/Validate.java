import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "contacts.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] values = line.split(",");
                String email = values[2];
                String phone = values[3];

                Matcher emailMatcher = emailPattern.matcher(email);
                Matcher phoneMatcher = phonePattern.matcher(phone);

                if (!emailMatcher.matches() || !phoneMatcher.matches()) {
                    System.out.printf("Invalid record: %s (Reason: %s)%n", line,
                            !emailMatcher.matches() ? "Invalid Email" : "Invalid Phone Number");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

