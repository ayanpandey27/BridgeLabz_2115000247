import java.util.*;

public class Handshake2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();
        int totalHandshakes = numberOfPeople * (numberOfPeople - 1) / 2;
        System.out.println(totalHandshakes);
        scanner.close();
    }
}
