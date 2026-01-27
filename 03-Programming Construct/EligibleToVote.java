import java.util.*;
public class EligibleToVote {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int age=sc.nextInt();
        if(age>=18){
            System.out.println("The Person Age Is ="+age+"And Can Vote");
        }
        else {
            System.out.println("The Person Age Is ="+age+"And Cannot Vote");
        }
    }
}