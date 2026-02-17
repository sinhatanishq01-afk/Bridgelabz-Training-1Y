import java.util.Scanner;

public class FactorsProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] factors = getFactors(num);

        System.out.println("Factors:");
        for (int f : factors) {
            System.out.print(f + " ");
        }

        System.out.println("\nGreatest Factor: " + greatestFactor(factors));
        System.out.println("Sum of Factors: " + sumFactors(factors));
        System.out.println("Product of Factors: " + productFactors(factors));
        System.out.println("Product of Cube of Factors: " + productCubeFactors(factors));
    }

    // a. Find factors using two loops
    static int[] getFactors(int n) {

        int count = 0;

        // First loop: count
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                count++;
        }

        int[] arr = new int[count];
        int index = 0;

        // Second loop: store
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                arr[index++] = i;
        }

        return arr;
    }

    // b. Greatest factor
    static int greatestFactor(int[] factors) {

        int max = factors[0];

        for (int f : factors) {
            if (f > max)
                max = f;
        }

        return max;
    }

    // c. Sum of factors
    static int sumFactors(int[] factors) {

        int sum = 0;

        for (int f : factors) {
            sum += f;
        }

        return sum;
    }

    // d. Product of factors
    static long productFactors(int[] factors) {

        long product = 1;

        for (int f : factors) {
            product *= f;
        }

        return product;
    }

    // e. Product of cube of factors
    static double productCubeFactors(int[] factors) {

        double product = 1;

        for (int f : factors) {
            product *= Math.pow(f, 3);
        }

        return product;
    }
}
