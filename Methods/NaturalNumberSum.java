import java.util.Scanner;

public class NaturalNumberSum {

    // Recursive method to find the sum of n natural numbers
    public static int recursiveSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + recursiveSum(n - 1);
    }

    // Method to calculate the sum using the formula
    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for n
        System.out.print("Enter a natural number (greater than 0): ");
        int n = scanner.nextInt();

        // Check if the input is a natural number
        if (n <= 0) {
            System.out.println("Invalid input. Please enter a natural number greater than 0.");
            return;
        }

        // Compute the sums
        int recursiveResult = recursiveSum(n);
        int formulaResult = formulaSum(n);

        // Print the results
        System.out.println("Sum of first " + n + " natural numbers (Recursive): " + recursiveResult);
        System.out.println("Sum of first " + n + " natural numbers (Formula): " + formulaResult);

        // Compare the results
        if (recursiveResult == formulaResult) {
            System.out.println("Both results are correct and match!");
        } else {
            System.out.println("Results do not match. There might be an error in the calculations.");
        }
    }
}

