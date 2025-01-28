import java.util.Scanner;

public class CollinearPoints {

    // Method to check if three points are collinear using slopes
    public static boolean areCollinearUsingSlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Calculate the slopes
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        
        // Check if the slopes are equal
        return slopeAB == slopeBC;
    }

    // Method to check if three points are collinear using the area of the triangle
    public static boolean areCollinearUsingArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Calculate the area of the triangle formed by the points (x1, y1), (x2, y2), (x3, y3)
        double area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        
        // If the area is zero, the points are collinear
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking inputs for 3 points
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();
        
        System.out.print("Enter x3: ");
        double x3 = scanner.nextDouble();
        System.out.print("Enter y3: ");
        double y3 = scanner.nextDouble();
        
        // Check collinearity using slope method
        if (areCollinearUsingSlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("The points are collinear using slope formula.");
        } else {
            System.out.println("The points are not collinear using slope formula.");
        }

        // Check collinearity using area method
        if (areCollinearUsingArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("The points are collinear using area of triangle formula.");
        } else {
            System.out.println("The points are not collinear using area of triangle formula.");
        }
        
        scanner.close();
    }
}

