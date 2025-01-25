import java.util.Scanner;

public class BMI2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of persons
        System.out.print("Enter the number of persons: ");
        int numberOfPersons = scanner.nextInt();

        // Multi-dimensional array to store height, weight, and BMI
        double[][] personData = new double[numberOfPersons][3];
        String[] weightStatus = new String[numberOfPersons];

        // Input height and weight, and calculate BMI
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");

            // Input height
            do {
                System.out.print("Enter height (in meters): ");
                personData[i][0] = scanner.nextDouble();
                if (personData[i][0] <= 0) System.out.println("Height must be positive.");
            } while (personData[i][0] <= 0);

            // Input weight
            do {
                System.out.print("Enter weight (in kilograms): ");
                personData[i][1] = scanner.nextDouble();
                if (personData[i][1] <= 0) System.out.println("Weight must be positive.");
            } while (personData[i][1] <= 0);

            // Calculate BMI
            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);

            // Determine weight status
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }

        // Display results
        System.out.println("\nResults:");
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height", "Weight", "BMI", "Status");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s%n", personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}

