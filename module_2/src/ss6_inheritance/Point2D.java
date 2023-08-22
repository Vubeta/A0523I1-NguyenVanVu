package ss6_inheritance;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{this.x, this.y};
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + this.x +
                ", y=" + this.y +
                '}';
    }
}

class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return this.z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[]{super.getX(), super.getY(), this.z};
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + super.getX() +
                ", y=" + super.getY() +
                ", z=" + this.z +
                '}';
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }
}

class TestPoint2DAndPoint3D {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(3.0f, 5.0f);

        Point3D point3D = new Point3D(5.0f, 7.0f, 9.0f);

        System.out.println(point2D);
        System.out.println(point3D);

        point2D.setXY(7.0f, 13.0f);
        point3D.setXYZ(17.0f, 31.0f, 23.0f);

        System.out.println(point2D);
        System.out.println(point3D);
    }
}