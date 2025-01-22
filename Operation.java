import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: a, b, c
        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();

        System.out.print("Enter the value of c: ");
        int c = scanner.nextInt();

        // Perform the integer operations
        int result1 = a + b * c;  // Multiplication (*) has higher precedence than addition (+)
        int result2 = a * b + c;  // Multiplication (*) has higher precedence than addition (+)
        int result3 = c + a / b;  // Division (/) has higher precedence than addition (+)
        int result4 = a % b + c;  // Modulus (%) has higher precedence than addition (+)

        // Output the results
        System.out.println("The results of Int Operations are:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);
    }
}

