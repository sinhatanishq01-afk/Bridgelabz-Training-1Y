public class NumberChecker3 {

    // A. Prime Number
    public static boolean isPrime(int num) {

        if (num <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    // Helper: Sum of digits
    private static int sumDigits(int num) {

        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    // Helper: Product of digits
    private static int productDigits(int num) {

        int product = 1;

        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }

        return product;
    }

    // B. Neon Number
    public static boolean isNeon(int num) {

        int square = num * num;
        return sumDigits(square) == num;
    }

    // C. Spy Number
    public static boolean isSpy(int num) {

        int sum = sumDigits(num);
        int product = productDigits(num);

        return sum == product;
    }

    // D. Automorphic Number
    public static boolean isAutomorphic(int num) {

        int square = num * num;
        String s1 = String.valueOf(num);
        String s2 = String.valueOf(square);

        return s2.endsWith(s1);
    }

    // E. Buzz Number
    public static boolean isBuzz(int num) {

        return (num % 7 == 0) || (num % 10 == 7);
    }
}
