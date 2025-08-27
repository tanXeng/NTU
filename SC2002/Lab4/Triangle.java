package Lab4;

public class Triangle implements Shape {
    private double height;
    private double base;

    public Triangle(double h, double b) {
        height = h;
        base = b;
    }
    
    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}
