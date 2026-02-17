import java.util.Scanner;

public class TriangularPark {

    static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000 / perimeter;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side 1 (meters): ");
        double s1 = sc.nextDouble();

        System.out.print("Enter side 2 (meters): ");
        double s2 = sc.nextDouble();

        System.out.print("Enter side 3 (meters): ");
        double s3 = sc.nextDouble();

        double rounds = calculateRounds(s1, s2, s3);

        System.out.println("Number of rounds to complete 5 km: " + rounds);

        sc.close();
    }
}
