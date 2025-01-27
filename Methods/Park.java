import java.util.*;
public class Park{
    public static double distance(double s1,double s2, double s3){
        return (5000/(s1+s2+s3));
        
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        double s1 = sc.nextDouble();
        double s2 = sc.nextDouble();
        double s3 = sc.nextDouble();
        double res = distance(s1,s2,s3);
        System.out.println(Math.floor(res));
    }
}
