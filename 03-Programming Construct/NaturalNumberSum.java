import java.util.*;
public class NaturalNumberSum {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int number=sc.nextInt();
        if(number>0){
            System.out.println("The Sum Of"+number+"Natural Number is"+number*(number+1)/2);
        }
        else{
            System.out.println("The Number is"+number+"is Not Natural Number");
        }
    }
}
