class Order {
    protected String orderId;
    protected String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return super.getOrderStatus() + ", Shipped with tracking number: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return super.getOrderStatus() + ", Delivered on: " + deliveryDate;
    }
}

public class OnlineRetailSystem {
    public static void main(String[] args) {
        Order order1 = new Order("ORD001", "2025-02-07");
        ShippedOrder order2 = new ShippedOrder("ORD002", "2025-02-06", "TRK12345");
        DeliveredOrder order3 = new DeliveredOrder("ORD003", "2025-02-05", "TRK67890", "2025-02-07");

        System.out.println(order1.getOrderStatus());
        System.out.println(order2.getOrderStatus());
        System.out.println(order3.getOrderStatus());
    }
}

