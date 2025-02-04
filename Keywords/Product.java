import java.util.Scanner; // Import Scanner for user input

class Product {
    static double discount = 10.0; // Shared discount for all products (in percentage)
    static int totalProducts = 0; // Tracks total products

    String productName;
    final int productID; // Unique identifier that cannot be changed
    double price;
    int quantity;

    // Constructor using 'this' to initialize instance variables
    Product(String productName, int productID, double price, int quantity) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
        totalProducts++; // Increase product count
    }

    // Static method to update discount
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }

    // Method to display product details (using instanceof)
    void displayDetails() {
        if (this instanceof Product) {
            System.out.println("\nProduct ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Total Price after Discount: $" + calculateDiscountedPrice());
            System.out.println("-------------------");
        }
    }

    // Method to calculate final price after discount
    double calculateDiscountedPrice() {
        return price * quantity * (1 - discount / 100);
    }
}

// Main class to take user input
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        // Taking input for first product
        System.out.print("Enter product name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter product ID: ");
        int id1 = scanner.nextInt();
        System.out.print("Enter product price: ");
        double price1 = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity1 = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product1 = new Product(name1, id1, price1, quantity1);

        // Taking input for second product
        System.out.print("\nEnter another product name: ");
        String name2 = scanner.nextLine();
        System.out.print("Enter another product ID: ");
        int id2 = scanner.nextInt();
        System.out.print("Enter another product price: ");
        double price2 = scanner.nextDouble();
        System.out.print("Enter another product quantity: ");
        int quantity2 = scanner.nextInt();

        Product product2 = new Product(name2, id2, price2, quantity2);

        // Display product details
        product1.displayDetails();
        product2.displayDetails();

        // Ask user if they want to update the discount
        System.out.print("\nEnter new discount percentage: ");
        double newDiscount = scanner.nextDouble();
        Product.updateDiscount(newDiscount);

        // Display updated product details after discount update
        product1.displayDetails();
        product2.displayDetails();

        scanner.close(); // Close scanner
    }
}

