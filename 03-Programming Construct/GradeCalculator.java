import java.util.*;
public class GradeCalculator {
    public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int physics=sc.nextInt();
      int chemistry=sc.nextInt();
      int maths=sc.nextInt();
      double per=(physics+chemistry+maths)/3;
      if(per<=39){
          System.out.println("Grade R Remedial Standard");
      }
      else if(per>=40&&per<=49){
          System.out.println("Grade E Too Below Normalized Standard");
      }
      else if(per>=50&&per<=59){
          System.out.println("Grade D Will Below Normalized Standard");
      }
      else if(per>=60&&per<=69){
          System.out.println("Grade C Below But Approaching Normalized Standard");
      }
      else if(per>=70&&per<=79){
          System.out.println("Grade B At Agency Normalized Standard");
      }
      else if(per>=80){
          System.out.println("Grade A Above Agency Normalized Standard");
      }
      else{
          System.out.println("Invalid");
      }
    }
}
