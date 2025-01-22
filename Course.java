public class Course {
    public static void main(String[] args) {
        // Course fee and discount percentage
        double fee = 125000;
        double discountPercent = 10;

        // Calculate discount and discounted price
        double discount = (fee * discountPercent) / 100;
        double discountedPrice = fee - discount;

        // Output the result
        System.out.printf("The discounted amount is INR %.2f and the price the student will pay is INR %.2f\n", 
                          discount, discountedPrice);
    }
}

