import java.util.Scanner;

public class Abundant {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int sumDivisors = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sumDivisors += i;
            }
        }

        if (sumDivisors > num) {
            System.out.println(num + " is an Abundant Number.");
        } else {
            System.out.println(num + " is not an Abundant Number.");
        }
    }
}

