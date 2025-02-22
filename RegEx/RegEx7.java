import java.util.*;

public class ExtractionProblems {
    public static void main(String[] args) {
        String text1 = "Contact us at support@example.com and info@company.org";
        extractEmails(text1);

        String text2 = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        extractCapitalizedWords(text2);

        String text3 = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        extractDates(text3);

        String text4 = "Visit https://www.google.com and http://example.org for more info.";
        extractLinks(text4);
    }

    public static void extractEmails(String text) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);
        List<String> emails = new ArrayList<>();
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        System.out.println("Emails: " + emails);
    }

    public static void extractCapitalizedWords(String text) {
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher = pattern.matcher(text);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        System.out.println("Capitalized Words: " + words);
    }

    public static void extractDates(String text) {
        Pattern pattern = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);
        List<String> dates = new ArrayList<>();
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        System.out.println("Dates: " + dates);
    }

    public static void extractLinks(String text) {
        Pattern pattern = Pattern.compile("https?://[^\\s]+");
        Matcher matcher = pattern.matcher(text);
        List<String> links = new ArrayList<>();
        while (matcher.find()) {
            links.add(matcher.group());
        }
        System.out.println("Links: " + links);
    }
}

