import java.util.Scanner;

public class MaximumOfThreeNumbers {

    public static void main(String[] args) {
        int[] numbers = takeInput();
        int max = findMaximum(numbers[0], numbers[1], numbers[2]);
        displayResult(max);
    }

    public static int[] takeInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter second number: ");
        int b = scanner.nextInt();

        System.out.print("Enter third number: ");
        int c = scanner.nextInt();

        scanner.close();
        return new int[]{a, b, c};
    }

    public static int findMaximum(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }

    public static void displayResult(int max) {
        System.out.println("Maximum number is: " + max);
    }
}