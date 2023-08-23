package ss6_inheritance;

import java.util.Scanner;

public class ShapeAndTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] sizeTriangle = new double[3];
        String color = "";
        do {
            System.out.println("Please enter size of triangle below");
            System.out.print("Side 1: ");
            sizeTriangle[0] = Double.parseDouble(scanner.nextLine());
            System.out.print("Side 2: ");
            sizeTriangle[1] = Double.parseDouble(scanner.nextLine());
            System.out.print("Side 3: ");
            sizeTriangle[2] = Double.parseDouble(scanner.nextLine());
        } while (sizeTriangle[0] + sizeTriangle[1] <= sizeTriangle[2] ||
                sizeTriangle[1] + sizeTriangle[2] <= sizeTriangle[0] ||
                sizeTriangle[0] + sizeTriangle[2] <= sizeTriangle[1]);
        System.out.print("Please enter the color of triangle: ");
        color = scanner.nextLine();

        Triangle triangle = new Triangle();
        triangle.setSide1(sizeTriangle[0]);
        triangle.setSide2(sizeTriangle[1]);
        triangle.setSide3(sizeTriangle[2]);
        triangle.setColor(color);
        System.out.println(triangle);
    }
}

class Shape {
    private String color = "red";

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
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
        double p = 0.5 * (this.side1 + this.side2 + this.side3);
        double area = Math.pow(p * (p - this.side1) * (p - this.side2) * (p - this.side3), 0.5);
        return area;
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + this.side1 +
                ", side2=" + this.side2 +
                ", side3=" + this.side3 +
                ", color=" + super.getColor() +
                ", area=" + this.getArea() +
                ", perimeter=" + this.getPerimeter() +
                '}';
    }
}
