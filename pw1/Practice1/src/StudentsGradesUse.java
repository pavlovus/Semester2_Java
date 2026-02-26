/*Практичне завдання №1, Вус Павло, ІПЗ-1,завдання №3
 *Написати клас StudentsGrades, що містить приватний масив цілих чисел, в якому зберігаються оцінки групи студентів (оцінки можуть мати значення від 0 до 100).

Клас повинен містити публічні методи для зчитування масиву (getter), присвоєння йому значення іншого масиву (setter)
* та додавання даних до нього (adder), а також методи, які повертають такі статистичні дані:*/
import utils.DataInput;


public class StudentsGradesUse {
    private static final int SENTINEL = -1;

    public static void main(String[] args) {
        StudentsGrades studentsGrades = new StudentsGrades();
         //Наповнення масиву
        int count = 1;
        System.out.println("Введіть оцінки студентів (від 0 до 100). Введіть "+ SENTINEL + " для завершення:");
        while (true) {
            int grade = DataInput.getInt("Введіть оцінку cтудента №" + count + " : ");
            if (grade == SENTINEL){
                break;
            } else if (grade < 0 || grade > 100) {
                System.out.println("Введіть оцінку ВІД 0 ДО 100 (або -1, щоб завершити ввід)");
                continue;
            }
            studentsGrades.addGrade(grade);
            count++;
        }

        //Вивід всієї інформації
        System.out.println(studentsGrades);
        System.out.println("Максимальна оцінка: " + studentsGrades.maxGrade());
        System.out.println("Мінімальна оцінка: " + studentsGrades.minGrade());
        System.out.println("Середній бал: " + studentsGrades.arithmeticMean());
        System.out.println("Кількість студентів з оцінкою вище середнього: " + studentsGrades.numberOfStudentsWithGradeBetterThanAverage());
        System.out.println("Кількість студентів з оцінкою нижче середнього: " + studentsGrades.numberOfStudentsWithGradeWorseThanAverage());
        System.out.println("Кількість студентів з відмінною оцінкою: " + studentsGrades.numberOfStudentsWithAGrade());
        System.out.println("Кількість студентів з оцінкою \"добре\": " + studentsGrades.numberOfStudentsWithBGrade());
        System.out.println("Кількість студентів з оцінкою \"задовільно\": " + studentsGrades.numberOfStudentsWithCGrade());
        System.out.println("Кількість студентів з оцінкою \"незадовільно\": " + studentsGrades.numberOfStudentsWithBadGrade());
    }
}
