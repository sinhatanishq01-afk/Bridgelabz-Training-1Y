public class NumberChecker {

    // Count digits
    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    // Store digits in array
    public static int[] storeDigits(int num) {

        String s = String.valueOf(num);
        int[] digits = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }

        return digits;
    }

    // Sum of digits
    public static int sumDigits(int[] digits) {

        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    // Sum of squares of digits
    public static double sumOfSquares(int[] digits) {

        double sum = 0;

        for (int d : digits) {
            sum += Math.pow(d, 2);
        }

        return sum;
    }

    // Harshad Number
    public static boolean isHarshad(int num, int[] digits) {

        int sum = sumDigits(digits);
        return num % sum == 0;
    }

    // Frequency of digits (2D array)
    public static int[][] digitFrequency(int[] digits) {

        int[][] freq = new int[10][2];

        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
        }

        for (int d : digits) {
            freq[d][1]++;
        }

        return freq;
    }

    // Reverse digits array
    public static int[] reverseDigits(int[] digits) {

        int[] rev = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            rev[i] = digits[digits.length - 1 - i];
        }

        return rev;
    }

    // Compare two arrays
    public static boolean compareArrays(int[] a, int[] b) {

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }

        return true;
    }

    // Palindrome number
    public static boolean isPalindrome(int[] digits) {

        int[] reversed = reverseDigits(digits);
        return compareArrays(digits, reversed);
    }

    // Duck Number
    public static boolean isDuckNumber(int[] digits) {

        for (int d : digits) {
            if (d != 0)
                return true;
        }

        return false;
    }
}
