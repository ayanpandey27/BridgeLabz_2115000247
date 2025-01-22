import java.util.Scanner;

public class Harshad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sumOfDigits = 0;
        int originalNumber = number;

        while (originalNumber != 0) {
            sumOfDigits += originalNumber % 10;
            originalNumber /= 10;
        }

        if (number % sumOfDigits == 0) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is not a Harshad Number.");
        }
    }
}

