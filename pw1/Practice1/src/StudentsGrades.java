/*Практичне завдання №1, Вус Павло, ІПЗ-1,завдання №3
 *Написати клас StudentsGrades, що містить приватний масив цілих чисел, в якому зберігаються оцінки групи студентів (оцінки можуть мати значення від 0 до 100).

Клас повинен містити публічні методи для зчитування масиву (getter), присвоєння йому значення іншого масиву (setter)
* та додавання даних до нього (adder), а також методи, які повертають такі статистичні дані:*/

import java.util.Arrays;

public class StudentsGrades {
    private int[] grades;
    //Конструктор
    public StudentsGrades() {
        this.grades = new int[0];
    }
    //Геттер
    public int[] getGrades() {
        return grades;
    }
    //Сеттер
    public void setGrades(int[] grades) {
        this.grades = grades;
    }
    //Аддер
    public void addGrade(int grade) {
        if(grade <= 100 && grade >= 0) {
            this.grades = Arrays.copyOf(this.grades, this.grades.length + 1);
            this.grades[this.grades.length - 1] = grade;
        } else {
            System.out.println("Оцінка повинна бути від 0 до 100!!!");
        }
    }
    //Метод, який повертає максимальну оцінку
    public int maxGrade() {
        if(grades.length == 0) {
            System.out.println("Схоже, що цей масив пустий. Спочатку вам потрібно в нього додати оцінки");
            return 0;
        } else {
            int max = grades[0];
            for(int grade : this.grades) {
                if(grade > max){
                    max = grade;
                }
            }
            return max;
        }
    }
    //Метод, який повертає мінімальну оцінку
    public int minGrade() {
        if(grades.length == 0) {
            System.out.println("Схоже, що цей масив пустий. Спочатку вам потрібно в нього додати оцінки");
            return 0;
        } else {
            int min = grades[0];
            for(int grade : this.grades) {
                if(grade < min){
                    min = grade;
                }
            }
            return min;
        }
    }
    //Середнє арифметичне
    public double arithmeticMean() {
        double sum = 0;
        for(int grade : this.grades){
            sum += grade;
        }
        if(grades.length != 0) {
            return sum / grades.length;
        } else {
            System.out.println("Схоже, що цей масив пустий. Спочатку вам потрібно в нього додати оцінки");
            return 0;
        }
    }
    //К-сть студентів з оцінкою вищою за середню
    public int numberOfStudentsWithGradeBetterThanAverage() {
        double average = arithmeticMean();
        int count = 0;
        for(int grade : this.grades){
            if(grade > average){
                count++;
            }
        }
        return count;
    }
    //К-сть студентів з оцінкою нищою за середню
    public int numberOfStudentsWithGradeWorseThanAverage() {
        double average = arithmeticMean();
        int count = 0;
        for(int grade : this.grades){
            if(grade < average){
                count++;
            }
        }
        return count;
    }
    //К-сть студентів з відмінною оцінкою
    public int numberOfStudentsWithAGrade() {
        int count = 0;
        for(int grade : this.grades){
            if(grade >= 91){
                count++;
            }
        }
        return count;
    }
    //К-сть студентів з оцінкою "добре"
    public int numberOfStudentsWithBGrade() {
        int count = 0;
        for(int grade : this.grades){
            if(grade <= 90 && grade >= 71){
                count++;
            }
        }
        return count;
    }
    //К-сть студентів з оцінкою "задовільно"
    public int numberOfStudentsWithCGrade() {
        int count = 0;
        for(int grade : this.grades){
            if(grade <= 70 && grade >= 60){
                count++;
            }
        }
        return count;
    }
    //К-сть студентів з оцінкою "незадовільно"
    public int numberOfStudentsWithBadGrade() {
        int count = 0;
        for(int grade : this.grades){
            if(grade < 60){
                count++;
            }
        }
        return count;
    }
    //Вивід всіх оцінок
    public String toString() {
        return "Оцінки студентів групи: " + Arrays.toString(grades);
    }
}
