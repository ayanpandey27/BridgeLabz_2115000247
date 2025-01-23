
import java.util.Scanner;
public class Youngest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the age of Amar: ");
        int ageAmar = scanner.nextInt();
        System.out.print("Enter the height of Amar: ");
        int heightAmar = scanner.nextInt();
        System.out.print("Enter the age of Akbar: ");
        int ageAkbar = scanner.nextInt();
        System.out.print("Enter the height of Akbar: ");
        int heightAkbar = scanner.nextInt();
        System.out.print("Enter the age of Anthony: ");
        int ageAnthony = scanner.nextInt();
        System.out.print("Enter the height of Anthony: ");
        int heightAnthony = scanner.nextInt();
        int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        int tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));

        System.out.println("The youngest age is: " + youngestAge);
        System.out.println("The tallest height is: " + tallestHeight);

        scanner.close();
    }
}


