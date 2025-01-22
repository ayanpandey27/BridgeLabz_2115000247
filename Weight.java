import java.util.Scanner;

public class Weight {
    public static void main(String[] args) {
        // Create a scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Input value for weight in pounds
        System.out.print("Enter the weight in pounds: ");
        double pounds = scanner.nextDouble();

        // Conversion factor
        double kilograms = pounds * 2.2;

        // Output the result
        System.out.println("The weight of the person in pounds is " + pounds + " and in kilograms is " + kilograms);

        // Close the scanner
        scanner.close();
    }
}

