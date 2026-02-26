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


public class StudentsGradesUse {
    public static void main(String[] args) {
        while(true) {
            StudentsGrades studentsGrades = new StudentsGrades();
            int choice1 = DataInput.getInt(" Введіть 1, щоб ввести масив оцінок вручну, або 0, щоб згенерувати її випадково:");
            while(true){
                if(choice1 == 1){
                    studentsGrades.setGrades(createArrayOfNumbersManually());
                    break;
                } else if(choice1 == 0){
                    studentsGrades.setGrades(createRandomArrayOfNumbers());
                    break;
                } else {
                    choice1 = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 АБО 0:");
                }
            }
            if(studentsGrades.checkForSort()){
                System.out.println("Масив правильно відсортований!!!");
            } else {
                System.out.println("Масив неправильно відсортований!!!");
            }
            studentsGrades.sortGrades();
            System.out.println(studentsGrades.toString());
            if(studentsGrades.checkForSort()){
                System.out.println("Масив правильно відсортований!!!");
            } else {
                System.out.println("Масив неправильно відсортований!!!");
            }
            /*
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
            */
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

    //Метод, який створює масив за введенеми числами користувача
    private static int[] createArrayOfNumbersManually() {
        int length = DataInput.getInt("Введіть довжину масиву, який будемо створювати: ");
        while(length <= 0){
            length = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
        }
        int[] arrayOfNumbers = new int[length];
        for (int i = 0; i <length; i++){
            arrayOfNumbers[i] = DataInput.getInt("Введіть "+(i+1)+"-ий елемент масиву: ");
        }
        System.out.println("Створений масив оцінок: "+ Arrays.toString(arrayOfNumbers));
        return arrayOfNumbers;
    }

    //Метод, який створює випадковий маисв цілих чисел
    private static int[] createRandomArrayOfNumbers() {
        int length = DataInput.getInt("Введіть довжину масиву, який будемо створювати: ");
        while(length <= 0){
            length = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
        }
        int[] arrayOfNumbers = new int[length];
        for (int i = 0; i <length; i++){
            arrayOfNumbers[i] =  random.nextInt(0, 100);
        }
        System.out.println("Згенерований масив оцінок"+ Arrays.toString(arrayOfNumbers));
        return arrayOfNumbers;
    }

     static Random random = new Random();
}
