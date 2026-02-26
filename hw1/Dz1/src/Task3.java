/*Домашнє завдання №1, Вус Павло, ІПЗ-1,завдання №3
 * Написати програму, що: зчитує студентів групи й записує в масив
виводить на екран інформацію про студентів
виводить на екран всіх студентів які починаються на вказану літеру (літеру прочитати з клавіатури)*/
import utils.DataInput;

import java.io.IOException;
import java.util.Arrays;

public class Task3 {
    private static final int SENTINEL = -1;

    public static void main(String[] args) throws IOException {
        while (true){
            String[] students = createStudentsArray();
            printStudentsArray(students);
            printSpecificStudentsArray(students);

            //Запитуємо чи користувач хоче продовжувати
            int choice = DataInput.getInt("Продовжуємо? Введіть 1 для продовження або 0 для виходу:");
            while(true){
                if(choice == 0){
                    System.out.println("Програма завершена!");
                    return;
                } else if(choice == 1){
                    break;
                } else {
                    choice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу:");
                }
            }
        }
    }

    private static void printSpecificStudentsArray(String[] students) {
        while(true){
            char firstLetter = DataInput.getChar("Введіть першу літеру, з якої починатимуться виведені студенти: ");
            String[] specificStudents = getStudentsThatStartWithLetter(students, firstLetter);
            if (specificStudents.length == 0){
                System.out.println("Схоже, що студентів, які починаються на цю літеру немає)))");
            } else {
                System.out.println("Студенти, які починаються з літери " + firstLetter + ": " + Arrays.toString(specificStudents));
            }

            //Запитуємо чи користувач хоче продовжувати
            int choice = DataInput.getInt("Продовжуємо виводити студентів по перших літерах? Введіть 1 для продовження або 0 для виходу:");
            while(true){
                if(choice == 0){
                    return;
                } else if(choice == 1){
                    break;
                } else {
                    choice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу:");
                }
            }
        }
    }

    private static String[] getStudentsThatStartWithLetter(String[] students, char firstLetter) {
        String[] result = new String[students.length];
        int count = 0;
        String letter = String.valueOf(firstLetter);
        for (String student : students) {
            if (student.charAt(0) == letter.toUpperCase().charAt(0) || student.charAt(0) == letter.toLowerCase().charAt(0)) {
                result[count++] = student;
            }
        }
        String[] finalResult = new String[count];
        System.arraycopy(result, 0, finalResult, 0, count);
        return finalResult;
    }

    private static boolean checkForFirstLetter(String student, char firstLetter) {
        return student.charAt(0) == firstLetter;
    }

    private static void printStudentsArray(String[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println("Студент №" + (i+1)  + ": " + students[i]);
        }
    }

    private static String[] createStudentsArray() throws IOException {
        int length = DataInput.getInt("Введіть кількість студентів в групі: ");
        String[] students = new String[length];
        for (int i =0; i<length; i++){
            students[i] = DataInput.getString("Введіть прізвище і ім'я студента групи №" + (i+1) + ": ");
        }
        return students;
    }
}