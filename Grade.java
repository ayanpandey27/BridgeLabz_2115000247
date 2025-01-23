import java.util.*;
public class Grade{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter marks:");
        int m=sc.nextInt();
        int p=sc.nextInt();
        int c=sc.nextInt();
        double av=(m+p+c)/3;
        if(av>=80){
            System.out.println("Average marks are :"+av);
            System.out.println("Grade A & Level 4,above agency normalized standards");
        }
        else if(av>=70 && av<=79){
            System.out.println("Average marks are :"+av);
            System.out.println("Grade B& Level 3,at agency normalized standards");
        }
        else if(av>=60 && av<=69){
            System.out.println("Average marks are :"+av);
            System.out.println("Grade C & Level 2,below but approaching agency normalized standards");
        }
        else if(av>=50 && av<=59){
            System.out.println("Average marks are :"+av);
            System.out.println("Grade D & Level 1,well below agency normalized standards");
        }
         else if(av>=40 && av<=49){
            System.out.println("Average marks are :"+av);
            System.out.println("Grade E & Level 1,too below agency normalized standards");
        }
        else if(av<=39){
            System.out.println("Average marks are :"+av);
            System.out.println("Grade R & Remedial standards");
        }
    }
}


