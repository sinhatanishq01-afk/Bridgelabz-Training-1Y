public class RandomNumbers {

    public static void main(String[] args) {

        RandomNumbers rn = new RandomNumbers();

        int[] numbers = rn.generate4DigitRandomArray(5);

        System.out.println("Generated Numbers:");
        for (int n : numbers) {
            System.out.print(n + " ");
        }

        double[] result = rn.findAverageMinMax(numbers);

        System.out.println("\nAverage: " + result[0]);
        System.out.println("Minimum: " + result[1]);
        System.out.println("Maximum: " + result[2]);
    }

    public int[] generate4DigitRandomArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 9000) + 1000;
        }

        return arr;
    }

    public double[] findAverageMinMax(int[] numbers) {

        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int n : numbers) {
            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        double avg = (double) sum / numbers.length;

        return new double[]{avg, min, max};
    }
}
