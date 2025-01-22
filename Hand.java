import java.util.Scanner;

public class Hands {

    public static void main(String[] args) {
        // Create a scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        
        // Calculate the maximum number of handshakes using the combination formula
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        
        // Output the result
        System.out.println("Maximum number of handshakes: " + maxHandshakes);
        
        // Close the scanner object
        scanner.close();
    }
}

