import java.util.Scanner;

public class GCD_LCM_Calculator {
    public static void main(String[] args) {
        int num1 = getInput("Enter first number: ");
        int num2 = getInput("Enter second number: ");
        
        int gcd = findGCD(num1, num2);
        int lcm = findLCM(num1, num2, gcd);
        
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }

    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static int findGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static int findLCM(int num1, int num2, int gcd) {
        return (num1 * num2) / gcd;
    }
}

