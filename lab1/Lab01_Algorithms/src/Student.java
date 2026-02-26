public class Student extends People {

    private int course;
    private int group;
    private static int numOfStudents;

    /**
     * Constructs a Student object.
     *
     * @param name the full name of the student
     * @param course the course number of the student
     * @param group the group number of the student
     */
    public Student(String name, int course, int group) {
        super(name);
        this.setCourse(course);
        this.group = group;
        numOfStudents++;
    }

    /**
     * Gets the total number of students.
     *
     * @return the total number of students
     */
    public static int getNumberOfStudents() {
        return numOfStudents;
    }

    /**
     * Gets the course number of the student.
     *
     * @return the course number of the student
     */
    public int getCourse() {
        return course;
    }

    /**
     * Sets the course number of the student.
     *
     * @param course the course number to set
     */
    public void setCourse(int course) {
        if (course < 0) {
            this.course = 0;
        } else {
            this.course = course;
        }
    }

    /**
     * Gets the group number of the student.
     *
     * @return the group number of the student
     */
    public int getGroup() {
        return group;
    }

    /**
     * Sets the group number of the student.
     *
     * @param group the group number to set
     */
    public void setGroup(int group) {
        this.group = group;
    }

    /**
     * Returns a string representation of the student.
     *
     * @return a string representation of the student
     */
    public String toString() {
        return fullName + ", курс - " + course + ", група - " + group;
    }

}
