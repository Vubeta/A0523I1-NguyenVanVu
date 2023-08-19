package ss5_access_modifier_and_static_method_and_static_property;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("Radius of circle 1 is " + circle1.getRadius());
        System.out.println("Area of circle 1 is " + circle1.getArea());

        Circle circle2 = new Circle(4);
        System.out.println("Radius of circle 2 is " + circle2.getRadius());
        System.out.println("Area of circle 2 is " + circle2.getArea());
    }
}

class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle() {
    }

    Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}