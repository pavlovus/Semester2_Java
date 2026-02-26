public class Student {
    private String  name;
    private int grade;
    private int age;

    public Student(String name, int grade, int age) {this.name=name;this.grade=grade;this.age=age;}

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {return age;}

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {this.age = age;}

    public String toString() {
        return name + " - " + grade;
    }
}