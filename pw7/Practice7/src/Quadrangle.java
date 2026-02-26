abstract class Quadrangle extends Polygon implements Perimeter{
    protected double sideA;
    protected double sideB;
    protected double sideC;
    protected double sideD;

    public Quadrangle(String name, String color, double centerX, double centerY, double sideA, double sideB, double sideC, double sideD) {
        super(name, color, centerX, centerY, 4);
        this.setSideA(sideA);
        this.setSideB(sideB);
        this.setSideC(sideC);
        this.setSideD(sideD);
    }

    @Override
    public void draw() {
        System.out.println("Малюємо чотирикутник: " + this);
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC + sideD;
    }

    public double getSideA() {
        return sideA;
    }
    public void setSideA(double sideA) {
        this.sideA = Math.max(sideA, 1);
    }
    public double getSideB() {
        return sideB;
    }
    public void setSideB(double sideB) {
        this.sideB = Math.max(sideB, 1);
    }
    public double getSideC() {
        return sideC;
    }
    public void setSideC(double sideC) {
        this.sideC = Math.max(sideC, 1);
    }
    public double getSideD() {
        return sideD;
    }
    public void setSideD(double sideD) {
        this.sideD = Math.max(sideD, 1);
    }

    @Override
    public String toString() {
        return super.toString() + ", сторони : " + sideA + ", " + sideB + ", " + sideC + ", " + sideD;
    }
}
