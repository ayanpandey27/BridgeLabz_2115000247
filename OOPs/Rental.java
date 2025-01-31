public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;

    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard Model";
        this.rentalDays = 1;
        this.dailyRate = 30.0; // Default daily rate
    }

    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    public CarRental(CarRental other) {
        this.customerName = other.customerName;
        this.carModel = other.carModel;
        this.rentalDays = other.rentalDays;
        this.dailyRate = other.dailyRate;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public String toString() {
        return "CarRental [Customer Name=" + customerName + ", Car Model=" + carModel + ", Rental Days=" + rentalDays + "]";
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental("John Doe", "Toyota Corolla", 5, 40.0);
        System.out.println(rental1);
        System.out.println("Total Rental Cost: $" + rental1.calculateTotalCost());

        CarRental rental2 = new CarRental();
        System.out.println(rental2);
        System.out.println("Total Rental Cost: $" + rental2.calculateTotalCost());

        CarRental rental3 = new CarRental(rental1);
        System.out.println(rental3);
        System.out.println("Total Rental Cost: $" + rental3.calculateTotalCost());
    }
}

