import java.util.Scanner;

public class Week {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month = input.nextInt();
        int day = input.nextInt();
        int year = input.nextInt();

        int tempYear = year - (14 - month) / 12;
        int x = tempYear + tempYear / 4 - tempYear / 100 + tempYear / 400;
        int tempMonth = month + 12 * ((14 - month) / 12) - 2;
        int dayOfWeek = (day + x + 31 * tempMonth / 12) % 7;

        System.out.println(dayOfWeek);
    }
}

