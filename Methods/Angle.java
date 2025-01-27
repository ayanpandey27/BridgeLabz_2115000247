import java.util.*;
public class Angle{
    public static double[] calangle(double angle){
        double radian = Math.toRadians(angle);
        double sine = Math.sin(radian);
        double cosine = Math.cos(radian);
        double tangent = Math.tan(radian);
        return new double[]{sine,cosine,tangent};
        
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        double angle = sc.nextDouble();
        double res[] = calangle(angle);
        System.out.println(res[0]);
        System.out.println(res[1]);
        System.out.println(res[2]);
    }
}
