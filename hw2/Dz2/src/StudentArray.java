import utils.DataInput;

import java.util.Arrays;

public class StudentArray {
    private Student[] arrayOfStudents;
    //Конструктори
    /**
     * Default constructor that initializes an empty array of Student objects
     */
    public StudentArray() {this.arrayOfStudents = new Student[0];}
    /**
     * Constructor that initializes an empty array of grades
     */
    public StudentArray(Student[] array) {this.arrayOfStudents = array;}

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
    //Метод, який сортує масив студентів за оцінками
    /**
     * Sorts the array of students in ascending or descending order based on grades.
     */
    public void sortStudents() {
        //Запитуємо, як будемо сортувати
        int choice = DataInput.getInt("Введіть 1, щоб сортувати студентів за алфавітом, або 0, щоб сортувати за оцінками: ");
        while(true){
            if(choice == 1){
                sortByName();
                break;
            } else if(choice == 0){
                sortByGrade();
                break;
            } else {
                choice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 - за алфавітом, 0 - за оцінками: ");
            }
        }
    }
    //Метод, який сортує масив студентів за алфавітом від А до Я
    /**
     * Sorts the array of students based on name from A to Z.
     */
    public void sortByNameAscending(Student[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = 0; k < arr[j].getName().length() && k < arr[minIndex].getName().length(); k++) {
                    if (arr[j].getName().toLowerCase().charAt(k) == arr[minIndex].getName().toLowerCase().charAt(k)) {
                        continue;
                    } else if (arr[j].getName().toLowerCase().charAt(k) < arr[minIndex].getName().toLowerCase().charAt(k)) {
                        minIndex = j;
                        break;
                    } else {
                        break;
                    }
                }

            }
            Student temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    //Метод, який сортує масив студентів за алфавітом від Я до А
    /**
     * Sorts the array of students based on name from Z to A.
     */
    public void sortByNameDescending(Student[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = 0; k < arr[j].getName().length() && k < arr[maxIndex].getName().length(); k++) {
                    if (arr[j].getName().toLowerCase().charAt(k) == arr[maxIndex].getName().toLowerCase().charAt(k)) {
                        continue;
                    } else if (arr[j].getName().toLowerCase().charAt(k) > arr[maxIndex].getName().toLowerCase().charAt(k)) {
                        maxIndex = j;
                        break;
                    } else {
                        break;
                    }
                }

            }
            Student temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
    //Метод, який сортує масив студентів за іменем
    /**
     * Sorts the array of students in ascending or descending order based on name.
     */
    public void sortByName() {
        //Запитуємо, як будемо сортувати
        int choice = DataInput.getInt("Введіть 1, щоб сортувати за зростанням(від А до Я), або 0, щоб сортувати за спаданням (від Я до А): ");
        while(true){
            if(choice == 0){
                sortByNameDescending(this.arrayOfStudents);
                break;
            } else if(choice == 1){
                sortByNameAscending(this.arrayOfStudents);
                break;
            } else {
                choice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 - за зростанням, 0 - за спаданням: ");
            }
        }
    }
    //Метод, який сортує масив студентів за оцінками
    /**
     * Sorts the array of students in ascending or descending order based on grades.
     */
    public void sortByGrade() {
        //Запитуємо, як будемо сортувати
        int choice = DataInput.getInt("Введіть 1, щоб сортувати за зростанням, або 0, щоб сортувати за спаданням: ");
        while(true){
            if(choice == 0){
                descendingSelectionSort(this.arrayOfStudents);
                break;
            } else if(choice == 1){
                ascendingSelectionSort(this.arrayOfStudents);
                break;
            } else {
                choice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 - за зростанням, 0 - за спаданням: ");
            }
        }
    }

    //Метод, який сортує масив студентів за спаданням оцінок
    /**
     * Sorts the array in descending order using selection sort.
     * @param arr The array to be sorted.
     */
    private void descendingSelectionSort(Student[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getGrade() > arr[maxIndex].getGrade()) {
                    maxIndex = j;
                }
            }
            Student temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }

    //Метод, який сортує масив студентів за зростанням оцінок
    /**
     * Sorts the array in ascending order using selection sort.
     * @param arr The array to be sorted.
     */
    private void ascendingSelectionSort(Student[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getGrade() < arr[minIndex].getGrade()) {
                    minIndex = j;
                }
            }
            Student temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

}
