import java.util.*;
    public class AreaTriangle {
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int base=sc.nextInt();
            int height=sc.nextInt();
            double areatriangle=(0.5*(base*height));
            double areainfeet=(areatriangle/30.48);
            System.out.println("Area of triangle in cm = "+ areatriangle + "in feet = "+areainfeet);


    }
}
