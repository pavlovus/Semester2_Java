import java.util.Arrays;

public class StudentGroup {
    private Student[] arrayOfStudents;
    //Конструктори
    /**
     * Default constructor that initializes an empty array of Student objects
     */
    public StudentGroup() {this.arrayOfStudents = new Student[0];}
    /**
     * Constructor that initializes an empty array of grades
     */
    public StudentGroup(Student[] array) {this.arrayOfStudents = array;}

    // Метод для виведення інформації про студентів
    /**
     * Print all students in the array
     */
    public void printStudents() {
        for (Student student : arrayOfStudents) {
            System.out.println(student.toString());
        }
    }
    //Аддер
    /**
     * Adds a student to the array.
     * @param student The student to be added.
     */
    public void addStudent(Student student) {
        this.arrayOfStudents = Arrays.copyOf(this.arrayOfStudents, this.arrayOfStudents.length + 1);
        this.arrayOfStudents[this.arrayOfStudents.length - 1] = student;
    }
    /**
     * This method finds and returns the student with the highest average grade in the group.
     * It iterates over the array of students and keeps track of the student with the highest grade.
     *
     * @return The student with the highest average grade, or null if the group is empty.
     */
    public Student getStudentWithMaxGrade() {
        Student student = null;
        int maxGrade = 0;
        for (Student stud : arrayOfStudents) {
            if(stud.getAverageGrade() >= maxGrade) {
                maxGrade = stud.getAverageGrade();
                student = stud;
            }
        }
        return student;
    }
    /**
     * This method finds and returns the student with the lowest average grade in the group.
     * It iterates over the array of students and keeps track of the student with the lowest grade.
     *
     * @return The student with the lowest average grade, or null if the group is empty.
     */
    public Student getStudentWithMinGrade() {
        Student student = null;
        int minGrade = 100;
        for (Student stud : arrayOfStudents) {
            if(stud.getAverageGrade() <= minGrade) {
                minGrade = stud.getAverageGrade();
                student = stud;
            }
        }
        return student;
    }

    public Student[] getStudentsWithMinGrade() {
        int count = 0;
        int minGrade = getStudentWithMinGrade().getAverageGrade();
        Student[] students = new Student[getNumberOfStudentsWithCertainGrade(minGrade)];
        for (Student stud : arrayOfStudents) {
            if(stud.getAverageGrade() == minGrade) {
                students[count] = stud;
                count++;
            }
        }
        return students;
    }

    public Student[] getStudentsWithMaxGrade() {
        int count = 0;
        int maxGrade = getStudentWithMaxGrade().getAverageGrade();
        Student[] students = new Student[getNumberOfStudentsWithCertainGrade(maxGrade)];
        for (Student stud : arrayOfStudents) {
            if(stud.getAverageGrade() == maxGrade) {
                students[count] = stud;
                count++;
            }
        }
        return students;
    }

    private int getNumberOfStudentsWithCertainGrade(int grade) {
        int count = 0;
        for (Student stud : arrayOfStudents) {
            if(stud.getAverageGrade() == grade) {
                count++;
            }
        }
        return count;
    }
}
