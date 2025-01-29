public class LongestWord {
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    public static void main(String[] args) {
        String sentence = "I am learning Java programming";
        System.out.println("Longest word: " + findLongestWord(sentence));
    }
}

