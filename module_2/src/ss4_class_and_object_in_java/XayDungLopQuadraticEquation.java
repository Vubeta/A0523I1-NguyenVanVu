package ss4_class_and_object_in_java;

import java.util.Scanner;

public class XayDungLopQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coefficient a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter coefficient b: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter coefficient c: ");
        double c = Double.parseDouble(scanner.nextLine());

        QuadraticEquation equation = new QuadraticEquation(a,b,c);
        double discriminant = equation.getDiscriminant();
        if (discriminant > 0) {
            System.out.println("The equation has two roots " + equation.getRoot1() + " and " + equation.getRoot2());
        } else if (discriminant == 0) {
            System.out.println("The equation has one root " + equation.getRoot1());
        } else {
            System.out.println("The equation has no real roots");
        }
    }
}

class QuadraticEquation {
    //data fields
    private double a, b, c;
    //constructor
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    //method
    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return this.b*this.b-4*this.a*this.c;
    }

    public double getRoot1() {
        if (getDiscriminant() >= 0) {
            return (-this.b+Math.pow(this.b*this.b-4*this.a*this.c,0.5))/(2*this.a);
        } else {
            return 0;
        }
    }

    public double getRoot2() {
        if (getDiscriminant() >= 0) {
            return (-this.b-Math.pow(this.b*this.b-4*this.a*this.c,0.5))/(2*this.a);
        } else {
            return 0;
        }
    }
}