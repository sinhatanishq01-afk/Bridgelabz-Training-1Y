import java.util.Scanner;

public class FibonacciGenerator {

    public static void main(String[] args) {
        int terms = getInput();
        generateFibonacci(terms);
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = scanner.nextInt();
        scanner.close();
        return n;
    }

    public static void generateFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        long first = 0, second = 1;

        System.out.print("Fibonacci Sequence: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");
            long next = first + second;
            first = second;
            second = next;
        }
    }
}