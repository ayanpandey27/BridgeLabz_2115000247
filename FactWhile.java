import java.util.Scanner;

public class FactWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        if (n >= 0) {
            int factorial = 1, i = 1;
            while (i <= n) {
                factorial *= i;
                i++;
            }
            System.out.println("Factorial: " + factorial);
        } else {
            System.out.println("Please enter a non-negative integer.");
        }

        scanner.close();
    }
}

