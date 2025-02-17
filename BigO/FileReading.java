import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) throws IOException {
        String filePath = "largefile.txt"; // Replace with actual file path

        long startTime = System.nanoTime();
        readUsingFileReader(filePath);
        long fileReaderTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        readUsingInputStreamReader(filePath);
        long inputStreamReaderTime = System.nanoTime() - startTime;

        System.out.println("FileReader Time: " + fileReaderTime / 1_000_000.0 + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1_000_000.0 + " ms");
    }

    public static void readUsingFileReader(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        while (fr.read() != -1) {} // Reads character by character
        fr.close();
    }

    public static void readUsingInputStreamReader(String filePath) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        while (isr.read() != -1) {} // Reads byte by byte, then converts to characters
        isr.close();
    }
}

