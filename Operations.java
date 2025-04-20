// Operations.java

public class Operations {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    public double square(double a) {
        return a * a;
    }

    public double cube(double a) {
        return a * a * a;
    }

    public double squareRoot(double a) throws IllegalArgumentException {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot compute the square root of a negative number.");
        }
        return Math.sqrt(a);
    }
}
