abstract class Shape {
    protected String name;
    protected String color;
    protected double centerX, centerY;

    public Shape(String name, String color, double centerX, double centerY) {
        this.name = name;
        this.color = color;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public abstract double area();
    public abstract double perimeter();
    public abstract void draw();

    public String toString() {
        return "Фігура " + name + ", колір: " + color + ", з центром (" + centerX + ", " + centerY + "), площа - "  + area() + ", периметер - " + perimeter();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public String getColor() {
        return color;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }
}
