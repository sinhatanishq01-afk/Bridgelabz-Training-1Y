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

        System.out.println("\nSum of factors: " + sumFactors(factors));
        System.out.println("Product of factors: " + productFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));
    }

    // Method to find factors and return array
    static int[] getFactors(int n) {

        int count = 0;

        // First loop: count factors
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        int[] arr = new int[count];
        int index = 0;

        // Second loop: store factors
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                arr[index++] = i;
            }
        }

        return arr;
    }

    // Method to find sum of factors
    static int sumFactors(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }

    // Method to find product of factors
    static long productFactors(int[] arr) {
        long product = 1;
        for (int x : arr) {
            product *= x;
        }
        return product;
    }

    // Method to find sum of squares of factors
    static double sumOfSquares(int[] arr) {
        double sum = 0;
        for (int x : arr) {
            sum += Math.pow(x, 2);
        }
        return sum;
    }
}
