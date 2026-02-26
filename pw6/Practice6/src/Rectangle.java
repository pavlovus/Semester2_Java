class Rectangle extends Quadrangle {
    private double length, width;

    public Rectangle(String color, double centerX, double centerY, double length, double width) {
        super("Rectangle", color, centerX, centerY, length, width, length, width);
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw(){
        System.out.println("Малюємо прямокутник: " + this);
    }
    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = Math.max(length, 1);
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.length = Math.max(length, 1);
    }
}
