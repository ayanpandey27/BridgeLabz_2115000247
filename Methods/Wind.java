import java.util.*;
public class Wind{
    public static double wind(double temp,double winds){
        return (35.74 + 0.6215) * temp + (0.4275*temp - 35.75) * Math.pow(winds,0.16);
        
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        double temp = sc.nextDouble();
        double winds = sc.nextDouble();
        double res = wind(temp,winds);
        System.out.println(res);
    }
}
