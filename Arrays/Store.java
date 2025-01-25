import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0;
        int index = 0;

        while (true) {
            System.out.print("Enter a number (or 0 or negative to stop): ");
            double number = scanner.nextDouble();

            if (number <= 0 || index == 10) {
                break;
            }

            numbers[index++] = number;
        }

        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        System.out.println("Total sum of the numbers: " + total);
    }
}

