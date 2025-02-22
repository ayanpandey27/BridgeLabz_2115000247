import java.util.regex.*;

public class RegexExamples {
    public static void main(String[] args) {
        System.out.println(validateUsername("user_123")); // true
        System.out.println(validateUsername("123user")); // false
        System.out.println(validateUsername("us")); // false
        
        System.out.println(validateLicensePlate("AB1234")); // true
        System.out.println(validateLicensePlate("A12345")); // false
        
        System.out.println(validateHexColor("#FFA500")); // true
        System.out.println(validateHexColor("#123")); // false
        
        extractEmails("Contact us at support@example.com and info@company.org");
        extractCapitalizedWords("The Eiffel Tower is in Paris and the Statue of Liberty is in New York.");
        extractDates("The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.");
        extractLinks("Visit https://www.google.com and http://example.org for more info.");
    }

    public static boolean validateUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    public static boolean validateLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\d{4}$");
    }

    public static boolean validateHexColor(String color) {
        return color.matches("^#([a-fA-F0-9]{6})$");
    }

    public static void extractEmails(String text) {
        Matcher matcher = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}").matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void extractCapitalizedWords(String text) {
        Matcher matcher = Pattern.compile("\\b[A-Z][a-z]*\\b").matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void extractDates(String text) {
        Matcher matcher = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void extractLinks(String text) {
        Matcher matcher = Pattern.compile("https?://[^\\s]+").matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
