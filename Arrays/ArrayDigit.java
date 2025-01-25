import java.util.Scanner;

public class ArrayDigit {
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

        // Reverse the digits array
        int[] reversedDigits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            reversedDigits[i] = digits[digitCount - 1 - i];
        }

        // Output reversed digits
        System.out.println("Digits in reverse order: ");
        for (int i = 0; i < reversedDigits.length; i++) {
            System.out.print(reversedDigits[i] + " ");
        }
        System.out.println();
    }
}

