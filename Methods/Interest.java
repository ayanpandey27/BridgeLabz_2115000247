
import java.util.*;
public class Main
{
	public static double cal(double p,double r,double t){
	    return (p*r*t)/100;
	    
	}
	public static void main(String [] args){
	    Scanner sc = new Scanner(System.in);
		double p = sc.nextDouble();
	    double r = sc.nextDouble();
		double t = sc.nextDouble();
		double cal1 = cal(p,r,t);
		System.out.println(cal1);
	    
	}
}

