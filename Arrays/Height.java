import java.util.Scanner;

public class Height {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0;

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter the height of player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }

        double meanHeight = sum / heights.length;
        System.out.println("The mean height of the players is: " + meanHeight);
    }
}

