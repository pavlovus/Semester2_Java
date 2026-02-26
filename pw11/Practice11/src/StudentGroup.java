import java.util.ArrayList;
import java.util.Arrays;

public class StudentGroup {
    private ArrayList<Student> groupOfStudents;
    //Конструктори
    /**
     * Default constructor that initializes an empty array of Student objects
     */
    public StudentGroup() {this.groupOfStudents = new ArrayList<>();}
    /**
     * Constructor that initializes an empty array of grades
     */
    public StudentGroup(Student[] array) {this.groupOfStudents = new ArrayList<>(Arrays.asList(array));}

    // Метод для виведення інформації про студентів
    /**
     * Print all students in the array
     */
    public void printStudents() {
        for (Student student : groupOfStudents) {
            System.out.println(student.toString());
        }
    }
    //Аддер
    /**
     * Adds a student to the array.
     * @param student The student to be added.
     */
    public void addStudent(Student student) {
        this.groupOfStudents.add(student);
    }
    /**
     * Remove a student from the array.
     * @param student The student to be removed.
     */
    public void removeStudent(Student student) {
        this.groupOfStudents.remove(student);
    }
    /**
     * Create a copy of current group and return it
     */
    public ArrayList<Student> getGroupOfStudents() {
        ArrayList<Student> newGroup = new ArrayList<>();
        newGroup.addAll(groupOfStudents);
        return newGroup;
    }

    public double getAverageScore() {
        double sum = 0;
        for (Student student : groupOfStudents) {
            sum += student.getGrade();
        }
        return sum / groupOfStudents.size();
    }

    public int getMaxScore() {
        int max = 0;
        for (Student student : groupOfStudents) {
            if (student.getGrade() > max) {
                max = student.getGrade();
            }
        }
        return max;
    }

    public int getMinScore() {
        int min = 0;
        for (Student student : groupOfStudents) {
            if (student.getGrade() < min || min == 0) {
                min = student.getGrade();
            }
        }
        return min;
    }
}

