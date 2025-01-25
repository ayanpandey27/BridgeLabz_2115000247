import java.util.*;
public class Grade2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of students ");
        int n=sc.nextInt();
        int[] m=new int[n];
        int[] p=new int[n];
        int[] c=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter marks for student "+(i+1));
            System.out.print("For Maths ");
            m[i]=sc.nextInt();
            while(m[i]<0){
                System.out.print("Enter positive marks");
                m[i]=sc.nextInt();
            }
            System.out.print("For Physics ");
            p[i]=sc.nextInt();
            while(p[i]<0){
                System.out.print("Enter positive marks");
                p[i]=sc.nextInt();
            }
            System.out.print("For Chemistry ");
            c[i]=sc.nextInt();
            while(c[i]<0){
                System.out.print("Enter positive marks");
                c[i]=sc.nextInt();
            }
            double av=(m[i]+p[i]+c[i])/3;
            if(av>=80){
                System.out.println("Percentage is "+av);
                System.out.println("Grade A & Level 4,above agency normalized standards");
            }
            else if(av>=70 && av<=79){
                System.out.println("Percentage is "+av);
                System.out.println("Grade B& Level 3,at agency normalized standards");
            }
            else if(av>=60 && av<=69){
                System.out.println("Percentage is "+av);
                System.out.println("Grade C & Level 2,below but approaching agency normalized standards");
            }
            else if(av>=50 && av<=59){
                System.out.println("Percentage is "+av);
                System.out.println("Grade D & Level 1,well below agency normalized standards");
            }
            else if(av>=40 && av<=49){
                System.out.println("Percentage is "+av);
                System.out.println("Grade E & Level 1,too below agency normalized standards");
            }
            else if(av<=39){
                System.out.println("Percentage is "+av);
                System.out.println("Grade R & Remedial standards");
            }
        }
    }
}
