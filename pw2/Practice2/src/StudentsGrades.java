/*Практичне завдання №1, Вус Павло, ІПЗ-1,завдання №3
 *Написати клас StudentsGrades, що містить приватний масив цілих чисел, в якому зберігаються оцінки групи студентів (оцінки можуть мати значення від 0 до 100).

Клас повинен містити публічні методи для зчитування масиву (getter), присвоєння йому значення іншого масиву (setter)
* та додавання даних до нього (adder), а також методи, які повертають такі статистичні дані:
*
* Практичне завдання №2, Вус Павло, ІПЗ-1
* До попереднього практичного додати метод, що вміє сортувати масив оцінок студентів. Реалізувати можливість сортувати як за зростанням так і за спаданням.

Реалізувати метод, що перевіряє, що масив правильно відсортований.

Має бути реалізований власний метод сортування. Оберіть той, що вам простіше реалізувати (детальний розгляд залишимо для курсу ОКА).

Можете за бажанням подивитися на Arrays.sort, але поки не використовувати.
* */

import utils.DataInput;

import java.util.Arrays;
import java.util.Random;

public class StudentsGrades {
    private int[] grades;

    //Конструктор
    /**
     * Default constructor that initializes an empty array of grades
     */
    public StudentsGrades() {
        this.grades = new int[0];
    }

    /**
     * Constructor that initializes grades with a given array.
     * @param arr Array of student grades.
     */
    public StudentsGrades(int[] arr) {this.grades = arr;}

    //Геттер
    /**
     * Getter method for grades.
     * @return Array of student grades.
     */
    public int[] getGrades() {
        return grades;
    }

    //Сеттер
    /**
     * Setter method for grades.
     * @param grades Array of student grades.
     */
    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    //Аддер
    /**
     * Adds a grade to the array if it is within the valid range (0-100).
     * @param grade The grade to be added.
     */
    public void addGrade(int grade) {
        if(grade <= 100 && grade >= 0) {
            this.grades = Arrays.copyOf(this.grades, this.grades.length + 1);
            this.grades[this.grades.length - 1] = grade;
        } else {
            System.out.println("Оцінка повинна бути від 0 до 100!!!");
        }
    }

    //Метод, який сортує масив оцінок студентів
    /**
     * Sorts the array of grades in ascending or descending order based on user input.
     */
    public void sortGrades() {
        //Запитуємо, як будемо сортувати
        int choice = DataInput.getInt("Введіть 1, щоб сортувати за зростанням, або 0, щоб сортувати за спаданням: ");
        while(true){
            if(choice == 0){
                descendingSelectionSort(this.grades);
                break;
            } else if(choice == 1){
                ascendingSelectionSort(this.grades);
                break;
            } else {
                choice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 - за зростанням, 0 - за спаданням: ");
            }
        }
    }

    //Метод, який сортує масив оцінок за спаданням
    /**
     * Sorts the array in descending order using selection sort.
     * @param arr The array to be sorted.
     */
    private void descendingSelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }

    //Метод, який сортує масив оцінок за зростанням
    /**
     * Sorts the array in ascending order using selection sort.
     * @param arr The array to be sorted.
     */
    private void ascendingSelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    //Метод, який перевіряє чи масив відсортований
    /**
     * Checks whether the array is sorted in the specified order.
     * @return True if sorted, false otherwise.
     */
    public boolean checkForSort() {
        //Запитуємо, як будемо сортувати
        int choice = DataInput.getInt("Введіть 1, щоб перевірити сортування за зростанням, або 0, щоб перевірити сортування за спаданням: ");
        while(true){
            if(choice == 0){
                return descendingSelectionSortCheck(this.grades);
            } else if(choice == 1){
                return ascendingSelectionSortCheck(this.grades);
            } else {
                choice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 - за зростанням, 0 - за спаданням: ");
            }
        }
    }

    //Метод, який перевіряє чи масив відсортований за зростанням
    /**
     * Checks if the array is sorted in ascending order.
     * @param grades The array to check.
     * @return True if sorted in ascending order, false otherwise.
     */
    public boolean ascendingSelectionSortCheck(int[] grades) {
        for (int i = 0; i < grades.length - 1; i++) {
            if (grades[i] > grades[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //Метод, який перевіряє чи масив відсортований за спаданням
    /**
     * Checks if the array is sorted in descending order.
     * @param grades The array to check.
     * @return True if sorted in descending order, false otherwise.
     */
    public boolean descendingSelectionSortCheck(int[] grades) {
        for (int i = 0; i < grades.length - 1; i++) {
            if (grades[i] < grades[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //Метод, який повертає максимальну оцінку
    /**
     * Returns the maximum grade from the grades array.
     * @return the highest grade
     */
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
    /**
     * Returns the minimum grade from the grades array.
     * @return the lowest grade
     */
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
    /**
     * Calculates and returns the average grade.
     * @return the arithmetic mean of the grades
     */
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
    /**
     * Counts the number of students with grades above the average.
     * @return the count of students
     */
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
    /**
     * Counts the number of students with grades lower than the average.
     * @return the count of students
     */
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
    /**
     * Calculates the number of students who received an excellent grade (91 or higher).
     * @return The number of students with an excellent grade.
     */
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
    /**
     * Calculates the number of students who received a good grade (71 to 90).
     * @return The number of students with a good grade.
     */
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
    /**
     * Calculates the number of students who received a satisfactory grade (60 to 70).
     * @return The number of students with a satisfactory grade.
     */
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
    /**
     * Calculates the number of students who received a failing grade (below 60).
     * @return The number of students with a failing grade.
     */
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
    /**
     * Returns a string representation of the grades array.
     * @return a string displaying the grades.
     */
    public String toString() {
        return "Оцінки студентів групи: " + Arrays.toString(grades);
    }
}
