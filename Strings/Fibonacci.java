import java.util.Scanner;

public class FibonacciGenerator {
    public static void main(String[] args) {
        int terms = getInput("Enter the number of terms in the Fibonacci sequence: ");
        generateFibonacci(terms);
    }

    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static void generateFibonacci(int terms) {
        int a = 0, b = 1;
        for (int i = 0; i < terms; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
}

