import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();
		int v =0,c=0;
		for(int i=0;i<str.length();i++){
		    if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' ||str.charAt(i)=='o' ||str.charAt(i)=='u'){
		        v++;
		        
		    }
		    else {
		        c++;
		    }
		}
		System.out.println(v);
		System.out.println(c);
	}
}

