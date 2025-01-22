import java.util.Scanner;

public class Height {
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter their height in centimeters
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();

        // Convert height to inches
        double heightInches = heightCm / 2.54;

        // Convert height to feet and remaining inches
        int feet = (int) (heightInches / 12);
        double inches = heightInches % 12;

        // Output the results
        System.out.printf("Your height in cm is %.2f while in feet is %d and inches is %.2f\n", heightCm, feet, inches);

        // Close the scanner
        input.close();
    }
}

