import java.util.*;
public class PriceCalculation {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int price=sc.nextInt();
        int quantity=sc.nextInt();
        int totalprice= price*quantity;
        System.out.println("The total purchase price is INR="+totalprice+ " if the quantity="+quantity+ " and unit price is INR= "+price);

    }
}