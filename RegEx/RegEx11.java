import java.util.Arrays;
import java.util.List;

public class StringModifier {
    
    public static String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }

    public static String censorBadWords(String text, List<String> badWords) {
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        String text1 = "This  is   an    example    with multiple   spaces.";
        System.out.println(replaceMultipleSpaces(text1));

        String text2 = "This is a damn bad example with some stupid words.";
        List<String> badWordsList = Arrays.asList("damn", "stupid");
        System.out.println(censorBadWords(text2, badWordsList));
    }
}

