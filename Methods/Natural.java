import java.util.*;
public class Natural{
    public static int Natural(int n){
        int count=0;
        for(int i=0;i<=n;i++){
            count+=i;
        }
        return count;
        
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = Natural(n);
        System.out.println(res);
    }
}
