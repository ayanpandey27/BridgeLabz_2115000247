import java.util.Scanner;

public class FactFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        if (n >= 0) {
            int factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            System.out.println("Factorial: " + factorial);
        } else {
            System.out.println("Please enter a non-negative integer.");
        }

        scanner.close();
    }
}

