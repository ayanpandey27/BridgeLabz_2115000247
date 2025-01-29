import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str1 ="";
        for(int i=str.length()-1;i>=0;i--){
            str1+=str.charAt(i);
            
        }
        if(str1.equals(str)){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not a Palindrome");
        }
    }
}
