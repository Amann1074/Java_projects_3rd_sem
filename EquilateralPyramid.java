// EquilateralPyramid.java
class EquilateralPyramid extends Shape implements Volume {
    private double baseLength;
    private double height;

    EquilateralPyramid(double baseLength, double height) {
        super("Equilateral Pyramid");
        this.baseLength = baseLength;
        this.height = height;
    }

    @Override
    double calculateArea() {
        double slantHeight = Math.sqrt((baseLength / 2) * (baseLength / 2) + height * height);
        return (baseLength * baseLength) + (2 * baseLength * slantHeight / 2);
    }

    @Override
    double calculatePerimeter() {
        return 4 * baseLength; // Perimeter of the base
    }

    @Override
    public double calculateVolume() {
        return (1.0 / 3) * (baseLength * baseLength) * height;
    }
}
