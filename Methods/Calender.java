import java.util.Scanner;
import java.util.Calendar;

public class CalendarDisplay {

    public static void displayCalendar(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        
        String monthName = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.ENGLISH);
        System.out.println("\n\t\t" + monthName + " " + year);
        
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("    ");
        }
        
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%4d", day);
            
            if ((firstDayOfWeek + day - 1) % 7 == 0) {
                System.out.println();
            }
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        
        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Please enter a value between 1 and 12.");
        } else {
            displayCalendar(month, year);
        }
        
        scanner.close();
    }
}

