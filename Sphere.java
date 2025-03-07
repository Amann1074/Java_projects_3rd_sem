// Sphere.java
class Sphere extends Shape implements Volume {
    private double radius;

    Sphere(double radius) {
        super("Sphere");
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 0; // Perimeter is not defined for a sphere
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3) * Math.PI * radius * radius * radius;
    }
}
