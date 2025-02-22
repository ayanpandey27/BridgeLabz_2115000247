
import java.util.regex.*;
import java.util.*;

public class DataExtractor {
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        Matcher matcher = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}").matcher(text);
        while (matcher.find()) emails.add(matcher.group());
        return emails;
    }
    
    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b[A-Z][a-z]+\\b").matcher(text);
        while (matcher.find()) words.add(matcher.group());
        return words;
    }
    
    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(text);
        while (matcher.find()) dates.add(matcher.group());
        return dates;
    }
    
    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        Matcher matcher = Pattern.compile("https?://\\S+").matcher(text);
        while (matcher.find()) links.add(matcher.group());
        return links;
    }
    
    public static void main(String[] args) {
        String emailText = "Contact us at support@example.com and info@company.org";
        String capitalizedText = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        String dateText = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        String linkText = "Visit https://www.google.com and http://example.org for more info.";
        
        System.out.println("Emails: " + extractEmails(emailText));
        System.out.println("Capitalized Words: " + extractCapitalizedWords(capitalizedText));
        System.out.println("Dates: " + extractDates(dateText));
        System.out.println("Links: " + extractLinks(linkText));
    }
}


