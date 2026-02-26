abstract class Polygon extends Shape {
    protected int numberOfSides;

    public Polygon(String name, String color, double centerX, double centerY,  int numberOfSides) {
        super(name, color, centerX, centerY);
        this.setNumberOfSides(numberOfSides);
    }
    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = Math.max(numberOfSides, 3);
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    @Override
    public String toString() {
        return super.toString() + ", к-сть сторін - : " + numberOfSides;
    }
}
