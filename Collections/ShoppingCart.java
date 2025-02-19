import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Double> cartOrder = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedCart = new TreeMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cartOrder.put(product, price);
        sortedCart.put(price, product);
    }

    public void displayCartOrder() {
        System.out.println("Cart Items (Order Added):");
        for (Map.Entry<String, Double> entry : cartOrder.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }

    public void displaySortedByPrice() {
        System.out.println("Cart Items (Sorted by Price):");
        for (Map.Entry<Double, String> entry : sortedCart.entrySet()) {
            System.out.println(entry.getValue() + " - $" + entry.getKey());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 1200.99);
        cart.addProduct("Mouse", 25.50);
        cart.addProduct("Keyboard", 45.75);
        cart.addProduct("Monitor", 200.00);

        System.out.println("\n--- Shopping Cart ---\n");
        cart.displayCartOrder();
        System.out.println();
        cart.displaySortedByPrice();
    }
}

