/*Практичне завдання №1, Вус Павло, ІПЗ-1,завдання №4
 * Вивести на консоль всі елементи двовимірного масиву дійсних чисел, які більші за а та менші за b, де а та b – введені з консолі цілі числа.
 * Передбачити можливість генерації масиву та введення з консолі. Результат, тобто отриманий масив, вивести на консоль*/
import utils.DataInput;

import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        while(true){
            System.out.println("Програма знаходить максимальне та мінімальне значення елементів випадкового одновимірного масиву дійсних чисел!");

            double[][] matrixOfNumbers = createMatrix();
            double lowerLimit = DataInput.getDouble("Введіть число a, за яке всі елементи нового масиву будуть більші: ");
            double upperLimit = DataInput.getDouble("Введіть число b, за яке всі елементи нового масиву будуть менші: ");
            double[] newArrayOfNumbers = transformMatrix(matrixOfNumbers, lowerLimit, upperLimit);
            if (newArrayOfNumbers.length == 0) {
                System.out.println("Масив пустий!");
            } else {
                System.out.println("Результат: " + Arrays.toString(newArrayOfNumbers));
            }
            //Запитуємо чи користувач хоче продовжувати
            int choice = DataInput.getInt("Продовжуємо? Введіть 1 для продовження або 0 для виходу: ");
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

    private static double[] transformMatrix(double[][] matrixOfNumbers, double lowerLimit, double upperLimit) {
        int length = 0;
        for (int i=0; i<matrixOfNumbers.length;i++){
            for (int j = 0;j<matrixOfNumbers[i].length;j++){
                if (matrixOfNumbers[i][j] > lowerLimit && matrixOfNumbers[i][j] < upperLimit) {
                    length++;
                }
            }
        }
        double[] newArrayOfNumbers = new double[length];
        length = 0;
        for (int i=0; i<matrixOfNumbers.length;i++){
            for (int j = 0;j<matrixOfNumbers[i].length;j++){
                if (matrixOfNumbers[i][j] > lowerLimit && matrixOfNumbers[i][j] < upperLimit) {
                    newArrayOfNumbers[length] = matrixOfNumbers[i][j];
                    length++;
                }
            }
        }
        return newArrayOfNumbers;
    }

    private static double[][] createMatrix() {
        int choice = DataInput.getInt(" Введіть 1, щоб ввести матрицю вручну, або 0, щоб згенерувати її випадково:");
        while(true){
            if(choice == 0){
                return createRandomMatrixOfNumbers();
            } else if(choice == 1){
                return createMatrixOfNumbersManually();
            } else {
                choice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 АБО 0:");
            }
        }
    }

    private static double[][] createMatrixOfNumbersManually() {
        int columns = DataInput.getInt("Введіть к-сть стовпчиків матриці, яку будемо створювати: ");
        while(columns <= 0){
            columns = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
        }
        int rows = DataInput.getInt("Введіть к-сть рядків матриці, яку будемо створювати: ");
        while(rows <= 0){
            rows = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
        }
        double[][] matrixOfNumbers = new double[rows][columns];
        for (int i=1; i<=matrixOfNumbers.length;i++){
            for (int j = 1;j<=matrixOfNumbers[i-1].length;j++){
                matrixOfNumbers[i-1][j-1] = DataInput.getDouble("Введіть елемент "+i+","+j+": ");
            }
        }
        System.out.println("Створена матриця: "+ Arrays.deepToString(matrixOfNumbers));
        return matrixOfNumbers;
    }

    private static double[][] createRandomMatrixOfNumbers() {
        int columns = DataInput.getInt("Введіть к-сть стовпчиків матриці, яку будемо створювати: ");
        while(columns <= 0){
            columns = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
        }
        int rows = DataInput.getInt("Введіть к-сть рядків матриці, яку будемо створювати: ");
        while(rows <= 0){
            rows = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
        }
        double[][] matrixOfNumbers = new double[rows][columns];
        for (int i = 0; i <rows; i++){
            for (int j = 0; j < columns; j++){
                matrixOfNumbers[i][j] = random.nextDouble(-100, 100);
            }
        }
        System.out.println("Згенерована матриця"+ Arrays.deepToString(matrixOfNumbers));
        return matrixOfNumbers;
    }

    static Random random = new Random();
}
