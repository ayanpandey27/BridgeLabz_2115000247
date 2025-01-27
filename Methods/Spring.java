import java.util.*;
public class Spring{
    public static boolean season(int day, int month){
        if (month == 3 && day >= 20) {
            return true;
        } else if (month == 4 || month == 5) {
            return true;
        } else if (month == 6 && day <= 20) {
            return true;
        }
        return false;
        
    
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int month = sc.nextInt();
        if(season(day,month)){
            System.out.println("It's Spring");
        }
        else{
            System.out.println("It's not Spring");
        }
    }
}
