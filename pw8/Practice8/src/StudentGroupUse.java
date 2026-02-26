/* Практичне завдання №8, Вус Павло, ІПЗ-1, група №6
Написати програму, що формує групу студентів.

Інформація про студентів (ПІБ, середній бал, адреса і т.д.) вводиться з клавіатури.

Групу, студента та введення інформації оформити у вигляді окремих класів.

Написати клас тестер який заповнює групу, виводить інформацію про групу студентів та повертає студента/ів з найкращим і найгіршим балом.


 */
import utils.DataInput;

import java.util.Arrays;

public class StudentGroupUse {
    public static void main(String[] args) {
        while (true){
            StudentReader studentReader = new StudentReader();
            int numberOfStudents = DataInput.getInt("Введіть к-сть студентів в цій групі: ");
            while (numberOfStudents < 1){
                numberOfStudents = DataInput.getInt("Ви маєте ввести ДОДАТНЄ число: ");
            }
            StudentGroup studentGroup = new StudentGroup();
            // Введення студентів та додавання їх в групу
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.println("Введіть інформацію про студента №" + (i + 1));
                Student student = studentReader.readStudent();
                studentGroup.addStudent(student);
            }
            //Вивід результатів
            studentGroup.printStudents();
            System.out.println("Студент з найвищою оцінкою в групі: ");
            System.out.println(Arrays.toString(studentGroup.getStudentsWithMaxGrade()));
            System.out.println("Студент з найнижчою оцінкою в групі: ");
            System.out.println(Arrays.toString(studentGroup.getStudentsWithMinGrade()));
            //Запитуємо чи користувач хоче продовжувати і створити новий масив
            int choice = DataInput.getInt("Продовжуємо? Введіть 1 для продовження або 0 для виходу: ");
            while(true){
                if(choice == 0){
                    System.out.println("Програма завершена!");
                    return;
                } else if(choice == 1){
                    break;
                } else {
                    choice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу: ");
                }
            }
        }
    }
}
