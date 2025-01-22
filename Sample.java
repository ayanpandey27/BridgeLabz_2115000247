import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the starting city: ");
        String fromCity = scanner.nextLine();

        System.out.print("Enter the city via which you will travel: ");
        String viaCity = scanner.nextLine();

        System.out.print("Enter the destination city: ");
        String toCity = scanner.nextLine();

        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = scanner.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = scanner.nextDouble();

        System.out.print("Enter the total time taken for the journey in hours: ");
        double timeTaken = scanner.nextDouble();

        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;

        System.out.println("Hello " + name + ", your journey details are as follows:");
        System.out.println("Starting city: " + fromCity);
        System.out.println("Via city: " + viaCity);
        System.out.println("Destination city: " + toCity);
        System.out.println("Total distance: " + totalDistance + " miles");
        System.out.println("Average speed: " + averageSpeed + " miles per hour");
    }
}
