import java.util.Scanner;

public class fee {
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the student fee
        System.out.print("Enter the student fee: INR ");
        double fee = input.nextDouble();

        // Prompt the user to enter the discount percentage
        System.out.print("Enter the university discount percentage: ");
        double discountPercent = input.nextDouble();

        // Calculate the discount amount
        double discount = (fee * discountPercent) / 100;

        // Calculate the final discounted fee
        double finalFee = fee - discount;

        // Output the results
        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f\n", discount, finalFee);

        // Close the scanner
        input.close();
    }
}

