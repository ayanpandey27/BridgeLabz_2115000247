import java.util.ArrayList;
class ECommercePlatformClass {
ArrayList&lt;Customer&gt; customers;
ArrayList&lt;Order&gt; orders;
public ECommercePlatformClass() {
customers = new ArrayList&lt;&gt;();
orders = new ArrayList&lt;&gt;();
}

public void addCustomer(Customer customer) {
customers.add(customer);
}
public void addOrder(Order order) {
orders.add(order);
}
}
class Customer {
String name;
ArrayList&lt;Order&gt; orders;
public Customer(String name) {
this.name = name;
orders = new ArrayList&lt;&gt;();
}
public void placeOrder(Order order) {
System.out.println(name + &quot; placed an order.&quot;);
orders.add(order);
}
}
class Order {
int orderId;
Customer customer;
ArrayList&lt;Product&gt; products;
public Order(int orderId, Customer customer) {
this.orderId = orderId;
this.customer = customer;
products = new ArrayList&lt;&gt;();
}
public void addProduct(Product product) {
System.out.println(&quot;Adding &quot; + product.getName() + &quot; to order &quot; +
orderId);
products.add(product);
}
}

class Product {
String name;
double price;
public Product(String name, double price) {
this.name = name;
this.price = price;
}
public String getName() {
return name;
}
public double getPrice() {
return price;
}
}
public class ECommercePlatform {
public static void main(String[] args) {
ECommercePlatformClass platform = new ECommercePlatformClass();
Customer customer1 = new Customer(&quot;John&quot;);
Customer customer2 = new Customer(&quot;Jane&quot;);
platform.addCustomer(customer1);
platform.addCustomer(customer2);
Product product1 = new Product(&quot;Laptop&quot;, 999.99);
Product product2 = new Product(&quot;Headphones&quot;, 199.99);
Product product3 = new Product(&quot;Smartphone&quot;, 799.99);
Order order1 = new Order(1, customer1);
Order order2 = new Order(2, customer2);
platform.addOrder(order1);
platform.addOrder(order2);
customer1.placeOrder(order1);
customer2.placeOrder(order2);
order1.addProduct(product1);

order1.addProduct(product2);
order2.addProduct(product3);
}
}
