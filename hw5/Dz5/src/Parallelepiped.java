public class Parallelepiped {
    private int x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4, sideRibLength, tiltAngle, baseSideLengthOne, baseSideLengthTwo, angleBetweenSidesOfBase, typeOfParallelepiped;
    /**
     * Constructor for a parallelepiped defined by four corner points.
     *
     * @param x1, y1, z1 - Coordinates of the first point.
     * @param x2, y2, z2 - Coordinates of the second point.
     * @param x3, y3, z3 - Coordinates of the third point.
     * @param x4, y4, z4 - Coordinates of the fourth point.
     */
    public Parallelepiped(int x1, int y1, int z1, int x2, int y2, int z2, int x3, int y3, int z3, int x4, int y4, int z4) {
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
        this.x3 = x3;
        this.y3 = y3;
        this.z3 = z3;
        this.x4 = x4;
        this.y4 = y4;
        this.z4 = z4;
        this.typeOfParallelepiped = 1;
    }
    /**
     * Constructor for an inclined parallelepiped with given side lengths and tilt angle.
     *
     * @param x1, y1, z1 - Coordinates of the first point.
     * @param x2, y2, z2 - Coordinates of the second point.
     * @param x3, y3, z3 - Coordinates of the third point.
     * @param sideRibLength - Length of a side rib.
     * @param tiltAngle - Tilt angle of the parallelepiped.
     */
    public Parallelepiped(int x1, int y1, int z1, int x2, int y2, int z2, int x3, int y3, int z3, int sideRibLength, int tiltAngle) {
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
        this.x3 = x3;
        this.y3 = y3;
        this.z3 = z3;
        this.sideRibLength = sideRibLength;
        this.tiltAngle = tiltAngle;
        this.typeOfParallelepiped = 2;
    }
    /**
     * Constructor for a parallelepiped with base side lengths, angle between sides, side rib length, and tilt angle.
     *
     * @param x1, y1, z1 - Coordinates of the first point.
     * @param baseSideLengthOne - Length of one side of the base.
     * @param baseSideLengthTwo - Length of the other side of the base.
     * @param angleBetweenSidesOfBase - Angle between the sides of the base in degrees.
     * @param sideRibLength - Length of the side rib.
     * @param tiltAngle - Tilt angle of the parallelepiped.
     */
    public Parallelepiped(int x1, int y1, int z1, int baseSideLengthOne, int baseSideLengthTwo, int angleBetweenSidesOfBase, int sideRibLength, int tiltAngle) {
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.baseSideLengthOne = baseSideLengthOne;
        this.baseSideLengthTwo = baseSideLengthTwo;
        this.angleBetweenSidesOfBase = angleBetweenSidesOfBase;
        this.sideRibLength = sideRibLength;
        this.tiltAngle = tiltAngle;
        this.typeOfParallelepiped = 3;
    }
    /**
     * Calculates the base area of the parallelepiped.
     *
     * For type 1 or type 2 (rectangular or inclined parallelepipeds), it calculates the area of the rectangular base.
     * For type 3 (parallelepiped with tilted sides), it calculates the area of the parallelogram base using the
     * formula: A = side1 * side2 * sin(angle_between_sides).
     *
     * @return The area of the base of the parallelepiped.
     */
    public double findBaseArea() {
        if (typeOfParallelepiped == 1 || typeOfParallelepiped == 2) {
            double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
            double width = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2) + Math.pow(z2 - z3, 2));
            return length * width;
        } else {
            return baseSideLengthOne * baseSideLengthTwo * Math.sin(Math.toRadians(angleBetweenSidesOfBase));
        }
    }
    /**
     * Calculates the height of the parallelepiped.
     *
     * For type 1 (rectangular parallelepiped), it calculates the height as the distance between the first and fourth points.
     * For type 2 and type 3 (inclined and base-angle parallelepipeds), it calculates the height based on the side rib length
     * and the tilt angle.
     *
     * @return The height of the parallelepiped.
     */
    public double findHeight() {
        if (typeOfParallelepiped == 1) {
            return Math.sqrt(Math.pow(x4 - x1, 2) + Math.pow(y4 - y1, 2) + Math.pow(z4 - z1, 2));
        } else {
            return sideRibLength * Math.sin(Math.toRadians(tiltAngle));
        }
    }
    /**
     * Calculates the volume (size) of the parallelepiped.
     *
     * The volume is calculated as the base area multiplied by the height.
     *
     * @return The volume of the parallelepiped.
     */
    public double findSize() {
        return findHeight() * findBaseArea();
    }
    //Гетери та сетери
    private int getX1() {
        return x1;
    }
    private int getY1() {
        return y1;
    }
    private int getZ1() {
        return z1;
    }
    private int getX2() {
        return x2;
    }
    private int getY2() {
        return y2;
    }
    private int getZ2() {
        return z2;
    }
    private int getSideRibLength() {
        return sideRibLength;
    }
    private void setSideRibLength(int sideRibLength) {
        this.sideRibLength = sideRibLength;
    }
    private int getTiltAngle() {
        return tiltAngle;
    }
    private void setTiltAngle(int tiltAngle) {
        this.tiltAngle = tiltAngle;
    }
    private int getBaseSideLengthOne() {
        return baseSideLengthOne;
    }
    private void setBaseSideLengthOne(int baseSideLengthOne) {
        this.baseSideLengthOne = baseSideLengthOne;
    }
    private int getBaseSideLengthTwo() {
        return baseSideLengthTwo;
    }
    private void setBaseSideLengthTwo(int baseSideLengthTwo) {
        this.baseSideLengthTwo = baseSideLengthTwo;
    }
    private int getAngleBetweenSidesOfBase() {
        return angleBetweenSidesOfBase;
    }
    private void setAngleBetweenSidesOfBase(int angleBetweenSidesOfBase) {
        this.angleBetweenSidesOfBase = angleBetweenSidesOfBase;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public int getZ3() {
        return z3;
    }

    public void setZ3(int z3) {
        this.z3 = z3;
    }
}
