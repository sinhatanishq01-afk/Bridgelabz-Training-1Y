import java.util.*;
public class SpringSeason {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int date=sc.nextInt();
        int month=sc.nextInt();
        if((month>=3&&date>=20&&month<=6&&date<=20)){
            System.out.println("Spring Season");
        }
        else{
            System.out.println("Not Spring Season");
        }
    }
}