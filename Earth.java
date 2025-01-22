public class Earth {
    public static void main(String[] args) {
        // Radius of Earth in kilometers
        double radiusKm = 6378;

        // Conversion factor from cubic kilometers to cubic miles
        double kmToMilesConversion = 0.621371;

        // Calculate volume of Earth in cubic kilometers
        double volumeKm3 = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);

        // Calculate volume of Earth in cubic miles
        double volumeMiles3 = volumeKm3 * Math.pow(kmToMilesConversion, 3);

        // Output the results
        System.out.printf("The volume of Earth in cubic kilometers is %.2f and in cubic miles is %.2f\n", 
                          volumeKm3, volumeMiles3);
    }
}
