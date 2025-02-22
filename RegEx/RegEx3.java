
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
}


