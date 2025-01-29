import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        double num1 = getInput("Enter first number: ");
        double num2 = getInput("Enter second number: ");
        System.out.println("Choose operation: 1. Add 2. Subtract 3. Multiply 4. Divide");
        int choice = getInput("Enter operation choice (1/2/3/4): ").intValue();
        
        double result = 0;
        switch (choice) {
            case 1: result = add(num1, num2); break;
            case 2: result = subtract(num1, num2); break;
            case 3: result = multiply(num1, num2); break;
            case 4: result = divide(num1, num2); break;
            default: System.out.println("Invalid operation choice.");
        }
        
        System.out.println("Result: " + result);
    }

    public static double getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return num1 / num2;
    }
}

