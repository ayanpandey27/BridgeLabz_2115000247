import java.util.*;
public class leapn{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if(year<1582){
            System.out.println("It is not a leap year");
        }
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            System.out.println("It is a leap year");
        }
        else{
            System.out.println("It is not a leap year");
        }
    }
}
