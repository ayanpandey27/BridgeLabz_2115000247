import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        // Count the number of digits
        int tempNumber = number;
        int digitCount = 0;
        while (tempNumber != 0) {
            tempNumber /= 10;
            digitCount++;
        }

        // Store digits in an array
        int[] digits = new int[digitCount];
        int index = 0;
        while (number != 0) {
            digits[index++] = number % 10; // Get last digit
            number /= 10; // Remove last digit
        }

        // Display digits in reverse order
        System.out.println("Reversed Number: ");
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}

