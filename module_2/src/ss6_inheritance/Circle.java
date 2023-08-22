package ss6_inheritance;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    protected double area = 1.0;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        this.area = Math.PI * this.radius * this.radius;
        return this.area;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + this.getRadius() +
                ", color='" + this.getColor() + '\'' +
                ", area=" + String.format("%.3f", this.getArea()) +
                '}';
    }
}

class Cylinder extends Circle {
    private double height = 1.0;
    private double volume = 1.0;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        this.volume = this.getArea() * this.height;
        return this.volume;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + this.getRadius() +
                ", color='" + this.getColor() + '\'' +
                ", height=" + this.getHeight() +
                ", area=" + String.format("%.3f", this.getArea()) +
                ", volume=" + String.format("%.3f", this.getVolume()) +
                '}';
    }
}

class TestCircleAndCylinder {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(7.0);
        circle.setColor("Yellow");

        Cylinder cylinder = new Cylinder();
        cylinder.setColor("Red");
        cylinder.setRadius(5.0);
        cylinder.setHeight(4.0);

        System.out.println(circle);
        System.out.println(cylinder);
    }
}