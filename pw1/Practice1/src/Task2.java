/*Практичне завдання №1, Вус Павло, ІПЗ-1,завдання №2
 * Знайти середньоарифметичне значення елементів одновимірного масиву цілих чисел.
 * Масив задати генерацією псевдовипадкових чисел. Результат вивести на консоль.*/
import utils.DataInput;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        while(true){
            System.out.println("Програма знаходить середнє арифметичне  елементів випадкового одновимірного масиву цілих чисел!");

            int length = DataInput.getInt("Введіть довжину масиву, який будемо сумувати: ");
            while(length <= 0){
                length = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
            }
            int[] arrayOfNumbers = new int[length];
            for (int i = 0; i <length; i++){
                arrayOfNumbers[i] =  random.nextInt(-100, 100);
            }
            System.out.println(Arrays.toString(arrayOfNumbers));

            double result = arithmeticMeanOfArray(arrayOfNumbers);
            System.out.println("Середнє арифметичне елементів масиву: " + result);

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

    private static double arithmeticMeanOfArray(int[] arrayOfNumbers) {
        double sum = 0;
        for(int number : arrayOfNumbers){
            sum += number;
        }
        return sum / arrayOfNumbers.length;
    }

    static Random random = new Random();
}
