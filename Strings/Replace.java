public class ReplaceWord {
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        return sentence.replaceAll("\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {
        String sentence = "Java is awesome, and Java is fun!";
        String oldWord = "Java";
        String newWord = "Python";
        System.out.println("Modified Sentence: " + replaceWord(sentence, oldWord, newWord));
    }
}

