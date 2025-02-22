
import java.util.regex.*;
import java.util.*;

public class RegexValidator {

    public static boolean validateIP(String ip) {
        String pattern = "^(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\."
                       + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\."
                       + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\."
                       + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";
        return Pattern.matches(pattern, ip);
    }

    public static boolean validateCreditCard(String card) {
        String pattern = "^(4\\d{15}|5[1-5]\\d{14})$";
        return Pattern.matches(pattern, card);
    }

    public static List<String> extractLanguages(String text) {
        String pattern = "\\b(Java|Python|JavaScript|Go|C|C\\+\\+|Ruby|Swift|Kotlin|Rust|Perl|PHP|TypeScript|R)\\b";
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        List<String> languages = new ArrayList<>();
        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }

    public static List<String> extractCurrency(String text) {
        String pattern = "\\$\\d+\\.\\d{2}|\\b\\d+\\.\\d{2}\\b";
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        List<String> currencyValues = new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        return currencyValues;
    }

    public static Set<String> findRepeatingWords(String text) {
        String pattern = "\\b(\\w+)\\b(?=.*\\b\\1\\b)";
        Matcher matcher = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE).matcher(text);
        Set<String> repeatingWords = new HashSet<>();
        while (matcher.find()) {
            repeatingWords.add(matcher.group());
        }
        return repeatingWords;
    }

    public static boolean validateSSN(String ssn) {
        String pattern = "^\\d{3}-\\d{2}-\\d{4}$";
        return Pattern.matches(pattern, ssn);
    }

    public static boolean validateUsername(String username) {
        String pattern = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        return Pattern.matches(pattern, username);
    }

    public static boolean validateLicensePlate(String plate) {
        String pattern = "^[A-Z]{2}\\d{4}$";
        return Pattern.matches(pattern, plate);
    }

    public static boolean validateHexColor(String color) {
        String pattern = "^#[0-9A-Fa-f]{6}$";
        return Pattern.matches(pattern, color);
    }

    public static void main(String[] args) {
        System.out.println(validateIP("192.168.1.1")); 
        System.out.println(validateCreditCard("4111111111111111"));
        System.out.println(extractLanguages("I love Java, Python, and JavaScript, but I haven't tried Go yet."));
        System.out.println(extractCurrency("The price is $45.99, and the discount is 10.50."));
        System.out.println(findRepeatingWords("This is is a repeated repeated word test."));
        System.out.println(validateSSN("123-45-6789"));
        System.out.println(validateUsername("user_123"));
        System.out.println(validateLicensePlate("AB1234"));
        System.out.println(validateHexColor("#FFA500"));
    }
}


