import java.util.Scanner;

public class MaxOfThree {
    public static void main(String[] args) {
        int num1 = getInput("Enter first number: ");
        int num2 = getInput("Enter second number: ");
        int num3 = getInput("Enter third number: ");
        
        int max = findMax(num1, num2, num3);
        System.out.println("The maximum number is: " + max);
    }

    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static int findMax(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
}

