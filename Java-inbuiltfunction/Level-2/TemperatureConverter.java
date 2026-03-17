import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature: ");
        double temp = scanner.nextDouble();

        System.out.print("Convert to (C/F): ");
        String unit = scanner.next().trim().toUpperCase();

        if (unit.equals("C")) {
            double celsius = fahrenheitToCelsius(temp);
            System.out.println(temp + "°F is " + celsius + "°C");
        } else if (unit.equals("F")) {
            double fahrenheit = celsiusToFahrenheit(temp);
            System.out.println(temp + "°C is " + fahrenheit + "°F");
        } else {
            System.out.println("Invalid unit. Please enter C or F.");
        }

        scanner.close();
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}