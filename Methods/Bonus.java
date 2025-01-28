import java.util.Random;

public class ZaraBonusCalculator {

    // Method to generate salary and years of service
    public static double[][] generateEmployeeData(int numEmployees) {
        Random rand = new Random();
        double[][] employeeData = new double[numEmployees][2]; // [0] = salary, [1] = years of service

        for (int i = 0; i < numEmployees; i++) {
            // Generating random salary between 10000 and 99999
            employeeData[i][0] = 10000 + (rand.nextInt(90000));
            // Generating random years of service between 1 and 20
            employeeData[i][1] = 1 + (rand.nextInt(20));
        }
        return employeeData;
    }

    // Method to calculate the new salary and bonus
    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        double[][] updatedData = new double[employeeData.length][3]; // [0] = old salary, [1] = new salary, [2] = bonus

        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonus = 0;

            // Determine bonus based on years of service
            if (yearsOfService > 5) {
                bonus = oldSalary * 0.05; // 5% bonus
            } else {
                bonus = oldSalary * 0.02; // 2% bonus
            }

            // Calculate new salary
            double newSalary = oldSalary + bonus;

            // Store data in updatedData
            updatedData[i][0] = oldSalary;
            updatedData[i][1] = newSalary;
            updatedData[i][2] = bonus;
        }

        return updatedData;
    }

    // Method to calculate the total of old salary, new salary, and total bonus
    public static void calculateTotalAmounts(double[][] updatedData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        // Summing up old salary, new salary, and total bonus
        for (int i = 0; i < updatedData.length; i++) {
            totalOldSalary += updatedData[i][0];
            totalNewSalary += updatedData[i][1];
            totalBonus += updatedData[i][2];
        }

        // Displaying the results in a tabular format
        System.out.println("---------------------------------------------------");
        System.out.println("Employee\tOld Salary\tNew Salary\tBonus");
        System.out.println("---------------------------------------------------");

        for (int i = 0; i < updatedData.length; i++) {
            System.out.printf("Employee %d\t%.2f\t%.2f\t%.2f\n", (i + 1), updatedData[i][0], updatedData[i][1], updatedData[i][2]);
        }

        System.out.println("---------------------------------------------------");
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
    }

    public static void main(String[] args) {
        int numEmployees = 10;

        // Step 1: Generate employee data (salary and years of service)
        double[][] employeeData = generateEmployeeData(numEmployees);

        // Step 2: Calculate bonus and new salary
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);

        // Step 3: Calculate and display totals and results
        calculateTotalAmounts(updatedData);
    }
}

