public class Lecturer extends People{

    private String degree;
    private static int numOfLecturers;

    /**
     * Constructs a Lecturer object.
     *
     * @param name the full name of the lecturer
     * @param degree the degree of the lecturer
     */
    public Lecturer(String name, String degree) {
        super(name);
        this.degree = degree;
        numOfLecturers++;
    }

    /**
     * Gets the total number of lecturers.
     *
     * @return the total number of lecturers
     */
    public static int getNumberOfLecturers() {
        return numOfLecturers;
    }

    /**
     * Gets the degree of the lecturer.
     *
     * @return the degree of the lecturer
     */
    public String getDegree() {
        return degree;
    }

    /**
     * Sets the degree of the lecturer.
     *
     * @param degree the degree to set
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * Returns a string representation of the lecturer.
     *
     * @return a string representation of the lecturer
     */
    public String toString() {
        return fullName + ", " + degree;
    }

}
