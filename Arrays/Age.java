import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        final int FRIEND_COUNT = 3;
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[FRIEND_COUNT];
        double[] heights = new double[FRIEND_COUNT];
        
        Scanner scanner = new Scanner(System.in);

        // Input loop for age and height
        for (int i = 0; i < FRIEND_COUNT; i++) {
            System.out.println("Enter age for " + names[i] + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid age: ");
                scanner.next(); // Clear invalid input
            }
            ages[i] = scanner.nextInt();
            if (ages[i] <= 0) {
                System.out.println("Age must be greater than 0. Please enter again.");
                i--; // Decrement index to repeat the input
                continue;
            }

            System.out.println("Enter height (in cm) for " + names[i] + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid height: ");
                scanner.next(); // Clear invalid input
            }
            heights[i] = scanner.nextDouble();
            if (heights[i] <= 0) {
                System.out.println("Height must be greater than 0. Please enter again.");
                i--; // Decrement index to repeat the input
            }
        }

        // Find the youngest and tallest friend
        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < FRIEND_COUNT; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Print the results
        System.out.println("\nResults:");
        System.out.println("Youngest Friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest Friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");
    }
}

