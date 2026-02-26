class Triangle extends Polygon {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String color, double centerX, double centerY, double sideA, double sideB, double sideC) {
        super("Triangle", color, centerX, centerY, 3);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public void draw() {
        System.out.println("Малюємо трикутник: " + this);
    }

    @Override
    public double area() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
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

    public String toString() {
        return super.toString() + ", сторони : " + sideA + ", " + sideB + ", " + sideC;
    }
}
