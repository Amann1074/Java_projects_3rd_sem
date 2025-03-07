// Shape.java
abstract class Shape {
    String shape;

    Shape(String shape) {
        this.shape = shape;
    }

    abstract double calculateArea();
    abstract double calculatePerimeter();

    public String getShape() {
        return shape;
    }
}
