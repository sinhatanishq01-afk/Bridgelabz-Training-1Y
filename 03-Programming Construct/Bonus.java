import java.util.*;
public interface Bonus {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int salary=sc.nextInt();
        int service=sc.nextInt();
        if(service>5){
            System.out.println(" 5% bonus Amount"+salary*5/100);
        }
        else{
            System.out.println("No Bonus Amount");
        }
    }
}
