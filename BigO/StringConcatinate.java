public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "A";

        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += text;
        }
        long stringTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long stringBuilderTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sf.append(text);
        }
        long stringBufferTime = System.nanoTime() - startTime;

        System.out.println("String Time: " + stringTime / 1_000_000.0 + " ms");
        System.out.println("StringBuilder Time: " + stringBuilderTime / 1_000_000.0 + " ms");
        System.out.println("StringBuffer Time: " + stringBufferTime / 1_000_000.0 + " ms");
    }
}

