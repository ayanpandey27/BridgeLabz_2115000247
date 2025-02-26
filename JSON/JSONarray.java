
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Car {
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {
        List<Car> cars = Arrays.asList(
            new Car("Toyota", "Camry", 2023),
            new Car("Honda", "Civic", 2022),
            new Car("Ford", "Mustang", 2024)
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = objectMapper.writeValueAsString(cars);

        System.out.println(jsonArray);
    }
}


