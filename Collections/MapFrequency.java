import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        for (String word : text.split("\\s+")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        System.out.println(countWordFrequency(text));
    }
}
.
