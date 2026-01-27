import java.util.*;
public class CountDownFor {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int number=sc.nextInt();
        for(int i=number;i>=1;i=i-1){
            System.out.println(i);
        }
    }
}