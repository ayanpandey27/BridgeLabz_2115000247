
import java.util.List;
import java.util.regex.Pattern;

public class StringProcessor {
    public static String cleanText(String text, List<String> badWords) {
        text = text.replaceAll("\\s+", " ");
        if (badWords != null) {
            for (String word : badWords) {
                text = text.replaceAll("(?i)\\b" + Pattern.quote(word) + "\\b", "****");
            }
        }
        return text;
    }

    public static void main(String[] args) {
        String inputText = "This is an example    with   multiple spaces.";
        System.out.println(cleanText(inputText, null));

        List<String> badWordsList = List.of("damn", "stupid");
        String inputTextWithBadWords = "This is a damn bad example with some stupid words.";
        System.out.println(cleanText(inputTextWithBadWords, badWordsList));
    }
}


