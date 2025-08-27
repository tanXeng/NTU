package Lab4;
import java.util.Scanner;

import org.w3c.dom.css.Rect;

public class Shape2DApp {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(25, 20);
        Rectangle rectangle = new Rectangle(50, 20);

        System.out.println(circle.getArea() + triangle.getArea() + rectangle.getArea());

    }
}
