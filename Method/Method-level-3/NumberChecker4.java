public class NumberChecker {

    // Helper: Sum of proper divisors
    public static int sumProperDivisors(int num) {

        int sum = 0;

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum;
    }

    // a. Perfect Number
    public static boolean isPerfect(int num) {

        if (num <= 0)
            return false;

        return sumProperDivisors(num) == num;
    }

    // b. Abundant Number
    public static boolean isAbundant(int num) {

        if (num <= 0)
            return false;

        return sumProperDivisors(num) > num;
    }

    // c. Deficient Number
    public static boolean isDeficient(int num) {

        if (num <= 0)
            return false;

        return sumProperDivisors(num) < num;
    }

    // Helper: factorial of a digit
    private static int factorial(int n) {

        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    // d. Strong Number
    public static boolean isStrong(int num) {

        int temp = num;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }

        return sum == num;
    }
}
