interface Worker {
    void performDuties();
}

class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing " + specialty + " dishes.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Chef, Specialty: " + specialty);
    }
}

class Waiter extends Person implements Worker {
    private int tablesAssigned;

    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers at " + tablesAssigned + " tables.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Waiter, Tables Assigned: " + tablesAssigned);
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("John", 202, 5);
        
        chef.displayDetails();
        chef.performDuties();
        System.out.println();
        
        waiter.displayDetails();
        waiter.performDuties();
    }
}

