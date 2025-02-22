
import java.util.*;
import java.util.regex.*;

public class RegexUtilities {

    public boolean isValidIPv4(String ip) {
        return ip.matches("((25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])");
    }

    public boolean isValidCreditCard(String cardNumber) {
        return cardNumber.matches("(4\\d{15})|(5[1-5]\\d{14})");
    }

    public List<String> extractLanguages(String text) {
        Matcher matcher = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b").matcher(text);
        List<String> result = new ArrayList<>();
        while (matcher.find()) result.add(matcher.group());
        return result;
    }

    public List<String> extractCurrencyValues(String text) {
        Matcher matcher = Pattern.compile("\\$?\\d+\\.\\d{2}").matcher(text);
        List<String> result = new ArrayList<>();
        while (matcher.find()) result.add(matcher.group());
        return result;
    }

    public Set<String> findRepeatingWords(String sentence) {
        Matcher matcher = Pattern.compile("\\b(\\w+)\\b(?:\\s+\\1\\b)+").matcher(sentence);
        Set<String> result = new HashSet<>();
        while (matcher.find()) result.add(matcher.group(1));
        return result;
    }

    public boolean isValidSSN(String ssn) {
        return ssn.matches("\\d{3}-\\d{2}-\\d{4}");
    }

    public static void main(String[] args) {
        RegexUtilities util = new RegexUtilities();

        System.out.println("Valid IPv4: " + util.isValidIPv4("192.168.1.1"));
        System.out.println("Valid Credit Card: " + util.isValidCreditCard("4111111111111111"));
        System.out.println("Extracted Languages: " + util.extractLanguages("I love Java, Python, and JavaScript, but I haven't tried Go yet."));
        System.out.println("Extracted Currency Values: " + util.extractCurrencyValues("The price is $45.99, and the discount is 10.50."));
        System.out.println("Repeating Words: " + util.findRepeatingWords("This is is a repeated repeated word test."));
        System.out.println("Valid SSN: " + util.isValidSSN("123-45-6789"));
    }
}


