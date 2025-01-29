import java.util.Scanner;

public class FactorialRecursion {
    public static void main(String[] args) {
        int number = getInput("Enter a number: ");
        System.out.println("Factorial of " + number + " is: " + factorial(number));
    }

    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static int factorial(int number) {
        if (number == 0) return 1;
        return number * factorial(number - 1);
    }
}

