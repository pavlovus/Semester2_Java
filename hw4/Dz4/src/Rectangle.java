public class Rectangle {
    private int x1, y1, x2, y2;
    /**
     * Constructor to initialize the rectangle with two diagonal points.
     * @param x1 x-coordinate of the first point.
     * @param y1 y-coordinate of the first point.
     * @param x2 x-coordinate of the second point.
     * @param y2 y-coordinate of the second point.
     */
    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    //Гетери
    /**
     * Returns the x-coordinate of the first point.
     * @return the x-coordinate of the first point.
     */
    public int getX1() {
        return x1;
    }
    /**
     * Returns the y-coordinate of the first point.
     * @return the y-coordinate of the first point.
     */
    public int getY1() {
        return y1;
    }
    /**
     * Returns the x-coordinate of the second point.
     * @return the x-coordinate of the second point.
     */
    public int getX2() {
        return x2;
    }
    /**
     * Returns the y-coordinate of the second point.
     * @return the y-coordinate of the second point.
     */
    public int getY2() {
        return y2;
    }
    //Сетери
    /**
     * Sets the x-coordinate of the first point.
     * @param x1 the new x-coordinate for the first point.
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }
    /**
     * Sets the y-coordinate of the first point.
     * @param y1 the new y-coordinate for the first point.
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }
    /**
     * Sets the x-coordinate of the second point.
     * @param x2 the new x-coordinate for the second point.
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }
    /**
     * Sets the y-coordinate of the second point.
     * @param y2 the new y-coordinate for the second point.
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }
    /**
     * Moves the rectangle by the given offsets in the x and y directions.
     * @param dx the change in the x-direction.
     * @param dy the change in the y-direction.
     */
    public void move(int dx, int dy) {
        setX1(x1 + dx);
        setY1(y1 + dy);
        setX2(x2 + dx);
        setY2(y2 + dy);
    }
    /**
     * Returns the union of this rectangle and another rectangle. The union is a rectangle
     * that contains both rectangles.
     * @param rect the other rectangle to calculate the union with.
     * @return a new rectangle representing the union of the two rectangles.
     */
    public Rectangle union(Rectangle rect) {
        int newX1 = Math.min(this.x1, rect.x1);
        int newY1 = Math.min(this.y1, rect.y1);
        int newX2 = Math.max(this.x2, rect.x2);
        int newY2 = Math.max(this.y2, rect.y2);
        return new Rectangle(newX1, newY1, newX2, newY2);
    }
    /**
     * Returns the intersection of this rectangle and another rectangle. The intersection is a rectangle
     * that is the common area of both rectangles.
     * @param rect the other rectangle to calculate the intersection with.
     * @return a new rectangle representing the intersection, or null if the rectangles do not intersect.
     */
    public Rectangle intersection(Rectangle rect) {
        int newX1 = Math.max(this.x1, rect.x1);
        int newY1 = Math.max(this.y1, rect.y1);
        int newX2 = Math.min(this.x2, rect.x2);
        int newY2 = Math.min(this.y2, rect.y2);
        if (newX1 <= newX2 && newY1 <= newY2) {
            return new Rectangle(newX1, newY1, newX2, newY2);
        }
        return null;
    }
    /**
     * Checks if a point is inside this rectangle.
     * @param x the x-coordinate of the point to check.
     * @param y the y-coordinate of the point to check.
     * @return true if the point is inside the rectangle, false otherwise.
     */
    public boolean containsPoint(int x, int y) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }
    /**
     * Returns a string representation of the rectangle in the format:
     * "Rectangle defined by two points: (x1, y1), (x2, y2)".
     * @return a string representation of the rectangle.
     */
    public String toString() {
        return "Прямокутник заданий двома точками: (" + x1 + ";" + y1 + "), (" + x2 + ";" + y2 + ")";
    }
}
