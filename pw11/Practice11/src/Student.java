public class Student {
    private String  name;
    private int grade;
    //Конструктори
    /**
     * Constructs a Student with the specified name and grade.
     *
     * @param name  the name of the student
     * @param grade the grade of the student
     */
    public Student(String name, int grade) {this.name=name;this.grade=grade;}
    /**
     * Constructs a Student with the specified name.
     *
     * @param name the name of the student
     */
    public Student(String name){this.name=name;}
    /**
     * Constructs a Student with the specified grade.
     *
     * @param grade the grade of the student
     */
    public Student(int grade){this.grade=grade;}
    //Гетери
    /**
     * Returns the grade of the student.
     *
     * @return the student's grade
     */
    public int getGrade() {
        return grade;
    }
    /**
     * Returns the name of the student.
     *
     * @return the student's name
     */
    public String getName() {
        return name;
    }
    //Сетери
    /**
     * Sets the grade of the student.
     *
     * @param grade the new grade of the student
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }
    /**
     * Sets the name of the student.
     *
     * @param name the new name of the student
     */
    public void setName(String name) {
        this.name = name;
    }
    //Вивід студента
    /**
     * Returns a string representation of the student.
     *
     * @return a string in the format "name - grade"
     */
    public String toString() {
        return name + " - " + grade;
    }
}