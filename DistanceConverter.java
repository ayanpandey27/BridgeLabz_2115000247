public class DistanceConverter {
    public static void main(String[] args) {
        // Distance in kilometers
        double kilometers = 10.8;

        // Conversion factor from kilometers to miles
        double conversionFactor = 1.6;

        // Convert kilometers to miles
        double miles = kilometers / conversionFactor;

        // Output the result
        System.out.printf("The distance %.2f km in miles is %.2f", kilometers, miles);
    }
}

