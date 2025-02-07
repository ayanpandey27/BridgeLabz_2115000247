interface Refuelable {
    void refuel();
}

class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayDetails() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle {
    private int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(model + " is charging with battery capacity: " + batteryCapacity + " kWh.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Electric Vehicle, Battery Capacity: " + batteryCapacity + " kWh");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity;

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling with fuel capacity: " + fuelCapacity + " liters.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Petrol Vehicle, Fuel Capacity: " + fuelCapacity + " liters");
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model S", 250, 100);
        PetrolVehicle toyota = new PetrolVehicle("Toyota Corolla", 180, 50);
        
        tesla.displayDetails();
        tesla.charge();
        System.out.println();
        
        toyota.displayDetails();
        toyota.refuel();
    }
}

