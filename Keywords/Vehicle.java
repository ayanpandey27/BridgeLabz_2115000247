import java.util.Scanner;

class Vehicle {
    static double registrationFee = 5000.0; // Common for all vehicles
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: " + registrationFee);
    }

    String ownerName;
    String vehicleType;
    final String registrationNumber; // Unique for each vehicle

    // Constructor using 'this' to initialize values
    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Display vehicle details (with instanceof check)
    void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("\nOwner: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Vehicle 1
        System.out.print("Enter owner name: ");
        String owner1 = scanner.nextLine();
        System.out.print("Enter vehicle type: ");
        String type1 = scanner.nextLine();
        System.out.print("Enter registration number: ");
        String regNum1 = scanner.nextLine();

        Vehicle vehicle1 = new Vehicle(owner1, type1, regNum1);

        // Input for Vehicle 2
        System.out.print("\nEnter another owner name: ");
        String owner2 = scanner.nextLine();
        System.out.print("Enter vehicle type: ");
        String type2 = scanner.nextLine();
        System.out.print("Enter registration number: ");
        String regNum2 = scanner.nextLine();

        Vehicle vehicle2 = new Vehicle(owner2, type2, regNum2);

        // Display details
        vehicle1.displayDetails();
        vehicle2.displayDetails();

        // Updating registration fee
        System.out.print("\nEnter new registration fee: ");
        double newFee = scanner.nextDouble();
        Vehicle.updateRegistrationFee(newFee);

        // Display updated details
        vehicle1.displayDetails();
        vehicle2.displayDetails();

        scanner.close();
    }
}

