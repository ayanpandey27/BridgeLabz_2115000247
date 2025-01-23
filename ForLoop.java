import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n > 0) {
            int formulaSum = n * (n + 1) / 2;
            int loopSum = 0;

            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }

            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + loopSum);

            if (formulaSum == loopSum) {
                System.out.println("Both computations are correct and match!");
            } else {
                System.out.println("There's an error, the results don't match.");
            }
        } else {
            System.out.println("The input is not a natural number. Please enter a positive integer.");
        }

        scanner.close();
    }
}

