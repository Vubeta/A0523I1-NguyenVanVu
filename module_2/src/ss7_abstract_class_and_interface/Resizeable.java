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
            String shapeType = shape.getClass().getSimpleName();
            double areaBefore = 0.0;
            double areaAfter = 0.0;
            double percent = Math.floor(Math.random() * (100 - 1 + 1)) + 1;
            if (shape instanceof Circle) {
                Circle object = (Circle) shape;
                areaBefore = object.getArea();
                object.resize(percent);
                areaAfter = object.getArea();
            } else if (shape instanceof Square) {
                Square object = (Square) shape;
                areaBefore = object.getArea();
                object.resize(percent);
                areaAfter = object.getArea();
            } else if (shape instanceof Rectangle) {
                Rectangle object = (Rectangle) shape;
                areaBefore = ((Rectangle) shape).getArea();
                object.resize(percent);
                areaAfter = object.getArea();
            }
            System.out.print("Before crease size, area of " + shapeType + " is " + String.format("%.2f", areaBefore) + ". ");
            System.out.println("After crease size " + percent + "%, area of " + shapeType + " is " + String.format("%.2f", areaAfter));
        }
    }
}