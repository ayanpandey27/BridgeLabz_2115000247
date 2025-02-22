
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class StringProcessor {

    public static boolean validateIPv4(String ip) {
        String regex = "^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        return Pattern.matches(regex, ip);
    }

    public static boolean validateCreditCard(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$") || cardNumber.matches("^5\\d{15}$");
    }

    public static List<String> extractProgrammingLanguages(String text) {
        String[] languages = {"Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "Swift", "Kotlin"};
        return Arrays.stream(languages).filter(text::contains).collect(Collectors.toList());
    }

    public static List<String> extractCurrencyValues(String text) {
        List<String> matches = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\$?\\d+(\\.\\d{2})?").matcher(text);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }

    public static Set<String> findRepeatingWords(String sentence) {
        String[] words = sentence.toLowerCase().split("\\s+");
        Set<String> wordSet = new HashSet<>();
        Set<String> repeatedWords = new HashSet<>();
        for (String word : words) {
            if (!wordSet.add(word)) {
                repeatedWords.add(word);
            }
        }
        return repeatedWords;
    }

    public static boolean validateSSN(String ssn) {
        return ssn.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }

    public static void main(String[] args) {
        System.out.println(validateIPv4("192.168.1.1"));
        System.out.println(validateIPv4("256.100.50.25"));

        System.out.println(validateCreditCard("4111111111111111"));
        System.out.println(validateCreditCard("5111111111111111"));

        System.out.println(extractProgrammingLanguages("I love Java, Python, and JavaScript, but I haven't tried Go yet."));

        System.out.println(extractCurrencyValues("The price is $45.99, and the discount is 10.50."));

        System.out.println(findRepeatingWords("This is is a repeated repeated word test."));

        System.out.println(validateSSN("123-45-6789"));
        System.out.println(validateSSN("123456789"));
    }
}


