import java.util.*;

public class BinaryNumbersQueue {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 0; i < N; i++) {
            String current = queue.poll();
            result.add(current);
            queue.offer(current + "0");
            queue.offer(current + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println("First " + N + " Binary Numbers: " + generateBinaryNumbers(N));
    }
}

