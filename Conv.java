import java.util.Scanner;

public class Conv {

    public static void main(String[] args) {
        // Create a scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the distance in feet
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = scanner.nextDouble();
        
        // Convert feet to yards (1 yard = 3 feet)
        double distanceInYards = distanceInFeet / 3;
        
        // Convert feet to miles (1 mile = 5280 feet)
        double distanceInMiles = distanceInFeet / 5280;
        
        // Output the results
        System.out.println("Distance in yards: " + String.format("%.2f", distanceInYards) + " yards");
        System.out.println("Distance in miles: " + String.format("%.5f", distanceInMiles) + " miles");
        
        // Close the scanner object
        scanner.close();
    }
}

