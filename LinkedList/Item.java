class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagement {
    private Item head = null;

    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void removeItemById(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head, prev = null;
        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null) {
            prev.next = temp.next;
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchItem(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchItemByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    public void displayAllItems() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Item ID: " + temp.itemId + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        inventory.addItemAtBeginning("Laptop", 101, 5, 1000.0);
        inventory.addItemAtEnd("Mouse", 102, 20, 25.0);
        inventory.addItemAtEnd("Keyboard", 103, 10, 50.0);

        System.out.println("All Items:");
        inventory.displayAllItems();

        System.out.println("Searching for Item ID 102:");
        inventory.searchItem(102);

        System.out.println("Updating Quantity of Item ID 101 to 8:");
        inventory.updateQuantity(101, 8);
        inventory.displayAllItems();

        System.out.println("Calculating Total Inventory Value:");
        inventory.calculateTotalValue();

        System.out.println("Removing Item ID 102:");
        inventory.removeItemById(102);
        inventory.displayAllItems();
    }
}

