import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        double fahrenheit = getInput("Enter temperature in Fahrenheit: ");
        double celsius = fahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + " Fahrenheit is equal to " + celsius + " Celsius.");

        celsius = getInput("Enter temperature in Celsius: ");
        fahrenheit = celsiusToFahrenheit(celsius);
        System.out.println(celsius + " Celsius is equal to " + fahrenheit + " Fahrenheit.");
    }

    public static double getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
}
`
