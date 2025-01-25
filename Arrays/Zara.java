import java.util.Scanner;

public class Zara {
    public static void main(String[] args) {
        final int EMPLOYEE_COUNT = 10;
        double[] salary = new double[EMPLOYEE_COUNT];
        double[] yearsOfService = new double[EMPLOYEE_COUNT];
        double[] bonus = new double[EMPLOYEE_COUNT];
        double[] newSalary = new double[EMPLOYEE_COUNT];
        
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        Scanner scanner = new Scanner(System.in);

        // Input loop for salary and years of service
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Enter salary for employee " + (i + 1) + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid salary: ");
                scanner.next(); // Clear invalid input
            }
            salary[i] = scanner.nextDouble();
            if (salary[i] <= 0) {
                System.out.println("Salary must be greater than 0. Please enter again.");
                i--; // Decrement index to repeat the input
                continue;
            }

            System.out.println("Enter years of service for employee " + (i + 1) + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number of years: ");
                scanner.next(); // Clear invalid input
            }
            yearsOfService[i] = scanner.nextDouble();
            if (yearsOfService[i] < 0) {
                System.out.println("Years of service cannot be negative. Please enter again.");
                i--; // Decrement index to repeat the input
            }
        }

        // Calculation loop for bonus and new salary
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05; // 5% bonus for more than 5 years
            } else {
                bonus[i] = salary[i] * 0.02; // 2% bonus for 5 years or less
            }
            newSalary[i] = salary[i] + bonus[i];

            // Accumulate totals
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Print results
        System.out.println("\nEmployee Bonus and Salary Details:");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.printf("Employee %d: Old Salary = %.2f, Bonus = %.2f, New Salary = %.2f%n",
                    i + 1, salary[i], bonus[i], newSalary[i]);
        }

        System.out.println("\nSummary:");
        System.out.printf("Total Old Salary: %.2f%n", totalOldSalary);
        System.out.printf("Total Bonus Payout: %.2f%n", totalBonus);
        System.out.printf("Total New Salary: %.2f%n", totalNewSalary);
    }
}

