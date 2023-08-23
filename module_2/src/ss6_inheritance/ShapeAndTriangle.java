package ss6_inheritance;

public class ShapeAndTriangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.setSide1(7.0);
        triangle.setSide2(4.0);
        triangle.setSide3(5.0);
        System.out.println(triangle);
    }
}

class Shape {
}

class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return this.side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return this.side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return this.side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        double p = 0.5*(this.side1+this.side2+this.side3);
        double area = Math.pow(p*(p-this.side1)*(p-this.side2)*(p-this.side3),0.5);
        return area;
    }

    public double getPerimeter() {
        return this.side1+this.side2+this.side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + this.side1 +
                ", side2=" + this.side2 +
                ", side3=" + this.side3 +
                ", area=" + this.getArea() +
                ", perimeter=" + this.getPerimeter() +
                '}';
    }
}
