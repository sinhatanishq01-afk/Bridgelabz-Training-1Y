import java.util.*;
public class BodyMassIndex {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Weight In KG");
        double weight=sc.nextDouble();
        System.out.println("Enter Height In CM");
        double height=sc.nextDouble();
        double heightinmeter=(height)/100;
        System.out.println("Height In Meter"+heightinmeter);
        double bmi=weight/(heightinmeter*heightinmeter);
        if(bmi<=18.4){
            System.out.println("UnderWeight");
        }
        else if(bmi>=18.5&&bmi<=24.9){
            System.out.println("Normal");
        }
        else if(bmi>=25&&bmi<=39.9){
            System.out.println("Overweight");
        }
        else if(bmi>=40){
            System.out.println("obese");
        }
        else{
            System.out.println("inavlid");
        }

    }
}
