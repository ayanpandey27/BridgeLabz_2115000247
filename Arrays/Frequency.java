import java.util.Scanner;

public class Frequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Handle negative numbers by taking the absolute value
        if (number < 0) {
            number = Math.abs(number);
        }

        // Array to store the frequency of digits (0-9)
        int[] frequency = new int[10];

        // Process each digit in the number
        while (number > 0) {
            int digit = number % 10; // Get the last digit
            frequency[digit]++;      // Increment the frequency of the digit
            number /= 10;            // Remove the last digit
        }

        // Display the frequency of each digit
        System.out.println("Digit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }
    }
}

