import java.util.*;
public class Check{
    public static int Check(int n){
        if(n>0){
            return 1;
            
        }
        else if(n<0){
            return -1;
            
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = Check(n);
        System.out.println(res);
    }
}
