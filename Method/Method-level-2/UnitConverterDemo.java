public class UnitConverterDemo {

    public static void main(String[] args) {

        System.out.println("10 Km to Miles: " + UnitConverter.convertKmToMiles(10));
        System.out.println("5 Miles to Km: " + UnitConverter.convertMilesToKm(5));

        System.out.println("2 Meters to Feet: " + UnitConverter.convertMetersToFeet(2));
        System.out.println("6 Feet to Meters: " + UnitConverter.convertFeetToMeters(6));

        System.out.println("3 Yards to Feet: " + UnitConverter.convertYardsToFeet(3));
        System.out.println("9 Feet to Yards: " + UnitConverter.convertFeetToYards(9));

        System.out.println("1 Meter to Inches: " + UnitConverter.convertMetersToInches(1));
        System.out.println("12 Inches to Meters: " + UnitConverter.convertInchesToMeters(12));

        System.out.println("10 Inches to Centimeters: " +
                UnitConverter.convertInchesToCentimeters(10));
    }
}
