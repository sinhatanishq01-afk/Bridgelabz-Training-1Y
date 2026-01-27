import java .util.*;
public class CountDownWhile {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int number=sc.nextInt();
        int i=number;
        while(i>=1){
            System.out.println(i);
            i--;
        }
    }
}