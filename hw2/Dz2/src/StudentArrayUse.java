import utils.DataInput;

import java.io.IOException;

public class StudentArrayUse {
    private static final int SENTINEL = -1;

    public static void main(String[] args) throws IOException {
        while (true){
            StudentArray students = new StudentArray();
            //Наповнення масиву
            int count = 1;
            System.out.println("Введіть оцінку студента(від 0 до 100), а потім його прізвище та(або) ім'я. Введіть "+ SENTINEL + " для завершення:");
            while (true) {
                int grade = DataInput.getInt("Введіть оцінку cтудента №" + count + " : ");
                if (grade == SENTINEL){
                    break;
                } else if (grade < 0 || grade > 100) {
                    System.out.println("Введіть оцінку ВІД 0 ДО 100 (або -1, щоб завершити ввід)");
                    continue;
                }
                String name = DataInput.getString("Введіть прізвище та(або) ім'я студента №" + count + " : ");
                Student student = new Student(name, grade);
                students.addStudent(student);
                count++;
            }

            students.printStudents();
            while (true) {
                students.sortStudents();
                students.printStudents();

                // Запитуємо, чи користувач хоче продовжувати сортування
                int choice;
                while (true) {
                    choice = DataInput.getInt("Продовжуємо сортувати цей масив? Введіть 1 для продовження або 0 для виходу: ");
                    if (choice == 0 || choice == 1) {
                        break;
                    } else {
                        System.out.println("Ви ввели неправильне число! Введіть 1 для продовження або 0 для виходу.");
                    }
                }
                if (choice == 0) {
                    System.out.println("Сортування завершено!");
                    break;
                }
            }

            //Запитуємо чи користувач хоче продовжувати і створити новий масив
            int secondChoice = DataInput.getInt("Продовжуємо? Введіть 1 для продовження або 0 для виходу: ");
            while(true){
                if(secondChoice == 0){
                    System.out.println("Програма завершена!");
                    return;
                } else if(secondChoice == 1){
                    break;
                } else {
                    secondChoice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу: ");
                }
            }
        }
    }
}
