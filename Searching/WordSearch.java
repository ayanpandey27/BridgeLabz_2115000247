public class WordSearch {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Hello world! This is a test sentence.",
            "Java programming is fun.",
            "Searching for a word in a sentence."
        };

        String word = "Java";
        System.out.println("Sentence containing '" + word + "': " + findSentenceWithWord(sentences, word));
    }
}

