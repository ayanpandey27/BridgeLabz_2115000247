import java.util.Scanner;

public class Vote {

    public static boolean canVote(int age) {
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i <10; i++) {
            System.out.print("Enter age of student " + (i+1) + ": ");
            ages[i] = scanner.nextInt();
        }

        for (int i = 0; i <10; i++){
            if (canVote(ages[i])) {
                System.out.println("Student " + (i+1) + " can vote.");
            } else {
                System.out.println("Student " + (i+1) + " cannot vote.");
            }
        }

        scanner.close();
    }
}

