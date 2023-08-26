package ss7_abstract_class_and_interface;

public interface Resizeable {
    void resize(double percent);
}

class TestResizeable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(4.0, "Yellow", true);
        shapes[1] = new Rectangle(3.0, 7.0, "Red", false);
        shapes[2] = new Square(6.0, "Green", true);

        for (Object shape : shapes) {
            System.out.println(shape);
        }

        for (Object shape : shapes) {
            double percent = Math.floor(Math.random() * (100 - 1 + 1)) + 1;
            if (shape instanceof Circle) {
                System.out.print("Before crease size, area of circle is " + String.format("%.2f", ((Circle) shape).getArea()) + ". ");
                ((Circle) shape).resize(percent);
                System.out.println("After crease size " + percent + "%, area of circle is " + String.format("%.2f", ((Circle) shape).getArea()));
            } else if (shape instanceof Rectangle) {
                System.out.print("Before crease size, area of rectangle is " + String.format("%.2f", ((Rectangle) shape).getArea()) + ". ");
                ((Rectangle) shape).resize(percent);
                System.out.println("After crease size " + percent + "%, area of rectangle is " + String.format("%.2f", ((Rectangle) shape).getArea()));
            } else if (shape instanceof Square) {
                System.out.print("Before crease size, area of square is " + String.format("%.2f", ((Square) shape).getArea()) + ". ");
                ((Square) shape).resize(percent);
                System.out.println("After crease size " + percent + "%, are of square is " + String.format("%.2f", ((Square) shape).getArea()));
            }
        }
    }
}