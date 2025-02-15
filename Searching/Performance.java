import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringConcatenation();
        compareFileReading("large_file.txt"); 
    }

    private static void compareStringConcatenation() {
        int iterations = 1_000_000;
        String text = "hello";

        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long bufferTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long builderTime = System.nanoTime() - startTime;

        System.out.println("StringBuffer time: " + bufferTime / 1_000_000 + " ms");
        System.out.println("StringBuilder time: " + builderTime / 1_000_000 + " ms");
    }

    private static void compareFileReading(String filePath) {
        System.out.println("\nReading file using FileReader...");
        long startTime = System.nanoTime();
        int wordCount1 = countWordsUsingFileReader(filePath);
        long fileReaderTime = System.nanoTime() - startTime;
        System.out.println("Word count: " + wordCount1 + " | Time: " + fileReaderTime / 1_000_000 + " ms");

        System.out.println("\nReading file using InputStreamReader...");
        startTime = System.nanoTime();
        int wordCount2 = countWordsUsingInputStreamReader(filePath);
        long inputStreamReaderTime = System.nanoTime() - startTime;
        System.out.println("Word count: " + wordCount2 + " | Time: " + inputStreamReaderTime / 1_000_000 + " ms");
    }

    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }

    private static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }
}

