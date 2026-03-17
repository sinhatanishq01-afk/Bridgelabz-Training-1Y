import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int low = 1;
        int high = 100;
        boolean correct = false;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it.");

        while (!correct && low <= high) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (high/low/correct)");

            String feedback = getUserFeedback(scanner);

            if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            } else if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Yay! I guessed your number correctly.");
                correct = true;
            } else {
                System.out.println("Invalid input. Please enter high, low, or correct.");
            }
        }

        scanner.close();
    }

    public static int generateGuess(int low, int high) {
        return low + (int)(Math.random() * (high - low + 1));
    }

    public static String getUserFeedback(Scanner scanner) {
        return scanner.nextLine().trim();
    }
}