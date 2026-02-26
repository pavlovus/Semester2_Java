/*Практичне завдання №1, Вус Павло, ІПЗ-1,завдання №1
* Знайти суму елементів одновимірного масиву дійсних чисел.
* Передбачити введення елементів масиву з консолі. Результат вивести на консоль. */
import utils.DataInput;

public class Task1 {
    public static void main(String[] args) {
        while(true){
            System.out.println("Програма знаходить суму елементів одновимірного масиву дійсних чисел!");

            int length = DataInput.getInt("Введіть довжину масиву, який будемо сумувати: ");
            while(length <= 0){
                length = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
            }
            double[] arrayOfNumbers = new double[length];
            for (int i = 0; i <length; i++){
                arrayOfNumbers[i] = DataInput.getDouble("Введіть "+(i+1)+"-ий елемент масиву: ");
            }

            double result = sumOfArray(arrayOfNumbers);
            System.out.println("Сума елементів масиву: " + result);

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

    private static double sumOfArray(double[] arrayOfNumbers) {
        double sum = 0;
        for(double number : arrayOfNumbers){
            sum += number;
        }
        return sum;
    }
}