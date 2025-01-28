import java.util.*;
public class Distnaceconv{
    public static double kmtomile(double km){
        return km*0.6213;
    }
    public static double miletokm(double mile){
        return mile*1.609;
    }
    public static double mettofeet(double metre){
        return metre*3.28;
    }
    public static double feettomet(double feet){
        return feet*0.30;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        double km = sc.nextDouble();
        double mile = sc.nextDouble();
        double metre = sc.nextDouble();
        double feet = sc.nextDouble();
        System.out.println("Km in mile is" +" " +kmtomile(km));
        System.out.println("mile in km is" +" "+miletokm(mile));
        System.out.println("metre in feet is"+" "+mettofeet(metre));
        System.out.println("feet in metre is"+" "+feettomet(feet));
    }
    
    
}
