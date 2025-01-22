import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        // Create a scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Input values for Principal, Rate, and Time
        System.out.print("Enter the Principal: ");
        double principal = scanner.nextDouble();
        
        System.out.print("Enter the Rate of Interest: ");
        double rate = scanner.nextDouble();
        
        System.out.print("Enter the Time (in years): ");
        double time = scanner.nextDouble();

        // Calculate Simple Interest
        double simpleInterest = (principal * rate * time) / 100;

        // Output the result
        System.out.println("The Simple Interest is " + simpleInterest + 
                           " for Principal " + principal + 
                           ", Rate of Interest " + rate + 
                           " and Time " + time);

        // Close the scanner
        scanner.close();
    }
}

