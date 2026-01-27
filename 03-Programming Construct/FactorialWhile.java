import java.util.*;
public class FactorialWhile {
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int number=sc.nextInt();
        int fact=1;
        int i=1;
        while(i<=number){
            fact=fact*i;
            i=i+1;
        }
        System.out.println(fact);

    }
}
