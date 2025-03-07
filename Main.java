// Main.java
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Square");
            System.out.println("4. Sphere");
            System.out.println("5. Cylinder");
            System.out.println("6. Equilateral Pyramid");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Circle
                    System.out.print("Enter the radius of the circle: ");
                    double circleRadius = scanner.nextDouble();
                    Circle circle = new Circle(circleRadius);
                    System.out.println("Area: " + circle.calculateArea());
                    System.out.println("Perimeter: " + circle.calculatePerimeter());
                    break;

                case 2: // Rectangle
                    System.out.print("Enter the length of the rectangle: ");
                    double rectangleLength = scanner.nextDouble();
                    System.out.print("Enter the width of the rectangle: ");
                    double rectangleWidth = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(rectangleLength, rectangleWidth);
                    System.out.println("Area: " + rectangle.calculateArea());
                    System.out.println("Perimeter: " + rectangle.calculatePerimeter());
                    break;

                case 3: // Square
                    System.out.print("Enter the side length of the square: ");
                    double squareSide = scanner.nextDouble();
                    Square square = new Square(squareSide);
                    System.out.println("Area: " + square.calculateArea());
                    System.out.println("Perimeter: " + square.calculatePerimeter());
                    break;

                case 4: // Sphere
                    System.out.print("Enter the radius of the sphere: ");
                    double sphereRadius = scanner.nextDouble();
                    Sphere sphere = new Sphere(sphereRadius);
                    System.out.println("Surface Area: " + sphere.calculateArea());
                    System.out.println("Volume: " + sphere.calculateVolume());
                    break;

                case 5: // Cylinder
                    System.out.print("Enter the radius of the cylinder: ");
                    double cylinderRadius = scanner.nextDouble();
                    System.out.print("Enter the height of the cylinder: ");
                    double cylinderHeight = scanner.nextDouble();
                    Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight);
                    System.out.println("Surface Area: " + cylinder.calculateArea());
                    System.out.println("Volume: " + cylinder.calculateVolume());
                    break;

                case 6: // Equilateral Pyramid
                    System.out.print("Enter the base length of the pyramid: ");
                    double pyramidBaseLength = scanner.nextDouble();
                    System.out.print("Enter the height of the pyramid: ");
                    double pyramidHeight = scanner.nextDouble();
                    EquilateralPyramid pyramid = new EquilateralPyramid(pyramidBaseLength, pyramidHeight);
                    System.out.println("Surface Area: " + pyramid.calculateArea());
                    System.out.println("Volume: " + pyramid.calculateVolume());
                    break;

                case 0: // Exit
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}
