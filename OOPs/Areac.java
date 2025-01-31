public class Circle {
    private double radius;

    // Constructor chaining: default value for radius
    public Circle() {
        this(1.0); // Calls the constructor with a user-provided value (1.0 by default)
    }

    // Constructor with user-provided radius value
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter method for radius
    public double getRadius() {
        return radius;
    }

    // Method to calculate area of the circle
    public double area() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference of the circle
    public double circumference() {
        return 2 * Math.PI * radius;
    }

    // String representation of the circle
    @Override
    public String toString() {
        return "Circle with radius " + radius;
    }

    public static void main(String[] args) {
        // Default circle with radius 1
        Circle defaultCircle = new Circle();
        System.out.println(defaultCircle);
        System.out.println("Area: " + defaultCircle.area());
        System.out.println("Circumference: " + defaultCircle.circumference());

        // User-defined circle with radius 5
        Circle userCircle = new Circle(5);
        System.out.println(userCircle);
        System.out.println("Area: " + userCircle.area());
        System.out.println("Circumference: " + userCircle.circumference());
    }
}

