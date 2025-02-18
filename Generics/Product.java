import java.util.ArrayList;
import java.util.List;

abstract class ProductCategory {
    private String name;

    public ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}

class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " - " + category.getName() + " - $" + price;
    }
}

class Catalog {
    private List<Product<? extends ProductCategory>> products = new ArrayList<>();

    public void addProduct(Product<? extends ProductCategory> product) {
        products.add(product);
    }

    public List<Product<? extends ProductCategory>> getProducts() {
        return products;
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }
}

class Marketplace {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        
        Product<BookCategory> book = new Product<>("Java Programming", 50.00, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 20.00, new ClothingCategory());
        Product<GadgetCategory> smartphone = new Product<>("Smartphone", 600.00, new GadgetCategory());

        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(smartphone);

        System.out.println("Before Discount:");
        for (Product<? extends ProductCategory> p : catalog.getProducts()) {
            System.out.println(p);
        }

        Catalog.applyDiscount(book, 10);
        Catalog.applyDiscount(shirt, 15);
        Catalog.applyDiscount(smartphone, 5);

        System.out.println("\nAfter Discount:");
        for (Product<? extends ProductCategory> p : catalog.getProducts()) {
            System.out.println(p);
        }
    }
}

