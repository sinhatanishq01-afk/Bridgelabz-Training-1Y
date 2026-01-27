import java.util.*;
public class SmallestOfThreeNumb {
    public static void main(String arrgs[]){
        Scanner sc=new Scanner(System.in);
        int a= sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        if(a<b&&a<c){
            System.out.println("Is the first number the smallest Yes");
        }
        else{
            System.out.println("Is the first number the smallest No");
        }
    }
}
