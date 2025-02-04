import java.util.Scanner;

class Patient {
    static String hospitalName = "City Hospital"; // Shared across all patients
    static int totalPatients = 0; // Tracks total number of patients

    String name;
    int age;
    String ailment;
    final int patientID; // Unique for each patient

    // Constructor using 'this' to initialize variables
    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    // Static method to display total patients
    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Display patient details (with instanceof check)
    void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("\nHospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Patient 1
        System.out.print("Enter patient name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter age: ");
        int age1 = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter ailment: ");
        String ailment1 = scanner.nextLine();
        System.out.print("Enter patient ID: ");
        int id1 = scanner.nextInt();
        scanner.nextLine();

        Patient patient1 = new Patient(name1, age1, ailment1, id1);

        // Input for Patient 2
        System.out.print("\nEnter another patient name: ");
        String name2 = scanner.nextLine();
        System.out.print("Enter age: ");
        int age2 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter ailment: ");
        String ailment2 = scanner.nextLine();
        System.out.print("Enter patient ID: ");
        int id2 = scanner.nextInt();

        Patient patient2 = new Patient(name2, age2, ailment2, id2);

        // Display details
        patient1.displayDetails();
        patient2.displayDetails();

        // Display total patients
        Patient.getTotalPatients();

        scanner.close();
    }
}

