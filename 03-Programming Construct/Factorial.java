import java.util.*;
public class Factorial {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int number= sc.nextInt();
        int fact=1;
        while(number<=0) {
            System.out.println("Please Enter Positive Number");
        }

            for (int i = 1; i <= number; i = i + 1) {
                fact = fact * i;

            }

            System.out.println(fact);

    }
}