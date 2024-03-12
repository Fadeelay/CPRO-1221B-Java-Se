package Assignment3;

import java.util.Scanner;

abstract class Shape {
    abstract double getArea();

    @Override
    public String toString() {
        return String.format("Area: %.2f", getArea());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return width * width;
    }
}

class Rectangle extends Square {
    private double height;

    public Rectangle(double width, double height) {
        super(width);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return getWidth() * height;
    }
}

public class AreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println("Welcome to the Area Calculator");
            System.out.print("Calculate area of a circle, square, or rectangle? (c/s/r): ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case 'c':
                    System.out.println("\nCIRCLE:");
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    Circle circle = new Circle(radius);
                    System.out.println(circle);
                    break;
                case 's':
                    System.out.println("\nSQUARE:");
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    Square square = new Square(width);
                    System.out.println(square);
                    break;
                case 'r':
                    System.out.println("\nRECTANGLE:");
                    System.out.print("Enter width: ");
                    double rectWidth = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double height = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(rectWidth, height);
                    System.out.println(rectangle);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.print("\nContinue? (y/n): ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y');
    }
}
