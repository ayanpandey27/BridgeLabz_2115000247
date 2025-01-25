import java.util.Scanner;

public class BMI_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number of persons
        System.out.print("Enter the number of persons: ");
        int numberOfPersons = scanner.nextInt();

        // Create arrays to store data
        double[] heights = new double[numberOfPersons];
        double[] weights = new double[numberOfPersons];
        double[] bmis = new double[numberOfPersons];
        String[] weightStatus = new String[numberOfPersons];

        // Input loop for height and weight
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("\nEnter details for Person " + (i + 1) + ":");
            
            // Input height
            System.out.print("Enter height (in meters): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid height: ");
                scanner.next();
            }
            heights[i] = scanner.nextDouble();
            if (heights[i] <= 0) {
                System.out.println("Height must be greater than 0. Please enter again.");
                i--;
                continue;
            }

            // Input weight
            System.out.print("Enter weight (in kilograms): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid weight: ");
                scanner.next();
            }
            weights[i] = scanner.nextDouble();
            if (weights[i] <= 0) {
                System.out.println("Weight must be greater than 0. Please enter again.");
                i--;
                continue;
            }
        }

        // Calculate BMI and determine weight status
        for (int i = 0; i < numberOfPersons; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]); // BMI formula
            weightStatus[i] = determineWeightStatus(bmis[i]);
        }

        // Display the results
        System.out.println("\nBMI Details:");
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height", "Weight", "BMI", "Weight Status");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s%n", heights[i], weights[i], bmis[i], weightStatus[i]);
        }
    }

    // Method to determine the weight status based on BMI
    private static String determineWeightStatus(double bmi) {
        if (bmi < 18.4) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25.0 && bmi < 39.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}

