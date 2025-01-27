import java.util.*;
public class Remainder{
    public static int[] rem(int num,int div){
        int q = num/div;
        int r = num%div;
        return new int[]{q,r};
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int div = sc.nextInt();
        int[] res = rem(num,div);
        System.out.println(res[0]);
        System.out.println(res[1]);
        
    }
    
}

