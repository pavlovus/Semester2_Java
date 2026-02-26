public class Student {
    private String name;
    private int age;
    private int averageGrade;

    public Student(String name, int age, int grade) {
        this.name = name;
        if (age < 16){
            this.age = 16;
        } else {
            this.age = age;
        }
        if (grade < 0 || grade > 100) {
            this.averageGrade = 0;
        } else {
            this.averageGrade = grade;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(int averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String toString() {
        return "ПІБ - " + name + ", вік - " + age + ", середня оцінка - " + averageGrade;
    }
}
