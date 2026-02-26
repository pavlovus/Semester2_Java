class Circle extends Shape {
    private double radius;

    public Circle(String color, double centerX, double centerY, double radius) {
        super("Circle", color, centerX, centerY);
        this.radius = radius;
    }

    @Override
    public void draw(){
        System.out.println("Малюємо коло: " + this);
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString() + ", радіус - : " + radius;
    }
}
