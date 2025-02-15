public class StringPerformanceComparison {
    public static void main(String[] args) {
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
}

