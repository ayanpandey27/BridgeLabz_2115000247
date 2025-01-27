import java.util.*;
public class Handshake {
    public static int calculateHandshakes(int numberOfPeople) {
        return (numberOfPeople * (numberOfPeople - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        int numberOfPeople = scanner.nextInt();
        int totalHandshakes = calculateHandshakes(numberOfPeople);
        System.out.printf("The total number of handshakes possible among %d people is %d.%n", 
                          numberOfPeople, totalHandshakes);
        scanner.close();
    }
}
