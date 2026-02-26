/*Практичне завдання №1, Вус Павло, ІПЗ-1,завдання №3
 * В двохвимірному масиві дійсних чисел знайти мінімальний та максимальний елементи.
 * Масив задати генерацією псевдовипадкових чисел. Результат вивести на консоль. */
import utils.DataInput;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        while(true){
            System.out.println("Програма знаходить максимальне та мінімальне значення елементів випадкового одновимірного масиву дійсних чисел!");

            int columns = DataInput.getInt("Введіть к-сть стовпчиків матриці, яку будемо створювати: ");
            while(columns <= 0){
                columns = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
            }
            int rows = DataInput.getInt("Введіть к-сть рядків матриці, яку будемо створювати: ");
            while(rows <= 0){
                rows = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
            }
            double[][] arrayOfNumbers = new double[rows][columns];
            for (int i = 0; i <rows; i++){
                for (int j = 0; j < columns; j++){
                    arrayOfNumbers[i][j] = random.nextDouble(-100, 100);
                }
            }
            System.out.println("Згенерований масив"+Arrays.deepToString(arrayOfNumbers));

            double max = findMax(arrayOfNumbers);
            System.out.println("Найбільший елемент масиву: " + max);

            double min = findMin(arrayOfNumbers);
            System.out.println("Найменший елемент масиву: " + min);

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

    private static double findMax(double[][] arrayOfNumbers) {
        if(arrayOfNumbers[0].length == 0){
            System.out.println("Схоже, що цей масив пустий. Спочатку вам потрібно в нього додати оцінки");
            return 0;
        } else {
            double max = arrayOfNumbers[0][0];
            for (int i = 0; i <arrayOfNumbers.length; i++){
                for (int j = 0; j < arrayOfNumbers[0].length; j++){
                    if(arrayOfNumbers[i][j] > max){
                        max = arrayOfNumbers[i][j];
                    }
                }
            }
            return max;
        }
    }

    private static double findMin(double[][] arrayOfNumbers) {
        if(arrayOfNumbers[0].length == 0){
            System.out.println("Схоже, що цей масив пустий. Спочатку вам потрібно в нього додати оцінки");
            return 0;
        } else {
            double min = arrayOfNumbers[0][0];
            for (int i = 0; i <arrayOfNumbers.length; i++){
                for (int j = 0; j < arrayOfNumbers[0].length; j++){
                    if(arrayOfNumbers[i][j] < min){
                        min = arrayOfNumbers[i][j];
                    }
                }
            }
            return min;
        }
    }

    static Random random = new Random();
}
