import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StudentGroup {
    private ArrayList<Student> groupOfStudents;

    public StudentGroup() {this.groupOfStudents = new ArrayList<>();}

    public StudentGroup(Student[] array) {this.groupOfStudents = new ArrayList<>(Arrays.asList(array));}

    public void printStudents() {
        for (Student student : groupOfStudents) {
            System.out.println(student.toString());
        }
    }

    public void addStudent(Student student) {
        this.groupOfStudents.add(student);
    }

    public void removeStudent(Student student) {
        this.groupOfStudents.remove(student);
    }

    public void sortByAge(){
        Collections.sort(groupOfStudents, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        });
    }

    public void sortByGrade() {
        Collections.sort(groupOfStudents, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s1.getGrade(), s2.getGrade());
            }
        });
    }
}

