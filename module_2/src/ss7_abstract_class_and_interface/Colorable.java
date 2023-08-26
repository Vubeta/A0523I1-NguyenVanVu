package ss7_abstract_class_and_interface;

import java.awt.*;

public interface Colorable {
    void howToColor();
}

class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(4.0, "Yellow", true);
        shapes[1] = new Rectangle(3.0, 7.0, "Red", false);
        shapes[2] = new Square(6.0, "Green", true);

        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        for (Shape shape : shapes) {
            String shapeType = shape.getClass().getSimpleName();
            if (shape instanceof Circle) {
                System.out.print("Area of " + shapeType + " is " + String.format("%.2f", ((Circle) shape).getArea()));
            } else if (shape instanceof Square) {
                System.out.print("\nArea of " + shapeType + " is " + String.format("%.2f", ((Square) shape).getArea()));
            } else if (shape instanceof Rectangle) {
                System.out.print("\nArea of " + shapeType + " is " + String.format("%.2f", ((Rectangle) shape).getArea()));
            }
            if (shape instanceof Colorable) {
                System.out.print(" and ");
                ((Colorable) shape).howToColor();
            }
        }
    }
}