import java.io.*;

public class WordCount {
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    public static void main(String[] args) {
        String filePath = "example.txt";
        String targetWord = "hello";
        System.out.println("Occurrences of '" + targetWord + "': " + countWordOccurrences(filePath, targetWord));
    }
}

