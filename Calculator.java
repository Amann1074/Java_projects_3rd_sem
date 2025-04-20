// Calculator.java

import java.util.Scanner;

public class Calculator {
    private Operations operations;

    public Calculator() {
        operations = new Operations();
    }

    public void displayMenu() {
        System.out.println("\nCalculator Menu:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Square");
        System.out.println("6. Cube");
        System.out.println("7. Square Root");
        System.out.println("8. Exit");
    }

    public void getUser Input(int choice) {
        Scanner scanner = new Scanner(System.in);
        try {
            double a, b = 0;
            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                a = scanner.nextDouble();
                System.out.print("Enter second number: ");
                b = scanner.nextDouble();
            } else {
                System.out.print("Enter number: ");
                a = scanner.nextDouble();
            }

            switch (choice) {
                case 1:
                    System.out.println("Result: " + operations.add(a, b));
                    break;
                case 2:
                    System.out.println("Result: " + operations.subtract(a, b));
                    break;
                case 3:
                    System.out.println("Result: " + operations.multiply(a, b));
                    break;
                case 4:
                    System.out.println("Result: " + operations.divide(a, b));
                    break;
                case 5:
                    System.out.println("Result: " + operations.square(a));
                    break;
                case 6:
                    System.out.println("Result: " + operations.cube(a));
                    break;
                case 7:
                    System.out.println("Result: " + operations.squareRoot(a));
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}
