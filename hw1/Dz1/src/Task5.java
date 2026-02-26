/*Домашнє завдання №1, Вус Павло, ІПЗ-1,завдання №5
 * Дано матрицю розміром N х N.
Знайти суму найменших елементів її непарних рядків і найбільших елементів її парних рядків.
Впорядкувати елементи у рядках за зростанням*/
import utils.DataInput;

import java.util.Arrays;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        while (true){
            int[][] matrix = createMatrix();
            int specificSum = findSpecificSum(matrix);
            System.out.println("Сума найменших елементів її непарних рядків і найбільших елементів її парних рядків: " + specificSum);
            transformMatrix(matrix);
            System.out.println("Матриця з впорядкованими елементами у рядках за зростанням: " + Arrays.deepToString(matrix));

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

    private static void transformMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                for(int k = j+1; k < matrix[i].length; k++){
                    if(matrix[i][j] > matrix[i][k]){
                        swapElements(matrix, i, j, k);
                    }
                }
            }
        }
    }

    private static void swapElements(int[][] matrix, int row, int col1, int col2) {
        int temp = matrix[row][col1];
        matrix[row][col1] = matrix[row][col2];
        matrix[row][col2] = temp;
    }

    private static int findSpecificSum(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            if ((i+1) % 2 == 0){
                sum += findMax(matrix[i]);
            } else{
                sum += findMin(matrix[i]);
            }
        }
        return sum;
    }

    private static int[][] createMatrix() {
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

    private static int[][] createMatrixOfNumbersManually() {
        int columns = DataInput.getInt("Введіть к-сть стовпчиків матриці, яку будемо створювати: ");
        while(columns <= 0){
            columns = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
        }
        int rows = DataInput.getInt("Введіть к-сть рядків матриці, яку будемо створювати: ");
        while(rows <= 0){
            rows = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
        }
        int[][] matrixOfNumbers = new int[rows][columns];
        for (int i=1; i<=matrixOfNumbers.length;i++){
            for (int j = 1;j<=matrixOfNumbers[i-1].length;j++){
                matrixOfNumbers[i-1][j-1] = DataInput.getInt("Введіть елемент "+i+","+j+": ");
            }
        }
        System.out.println("Створена матриця: "+ Arrays.deepToString(matrixOfNumbers));
        return matrixOfNumbers;
    }

    private static int[][] createRandomMatrixOfNumbers() {
        int columns = random.nextInt(1, 5);
        int rows = random.nextInt(1, 5);
        int[][] matrixOfNumbers = new int[rows][columns];
        for (int i=0; i<matrixOfNumbers.length;i++){
            for (int j = 0;j<matrixOfNumbers[i].length;j++){
                matrixOfNumbers[i][j] = random.nextInt(1, 100);
            }
        }
        System.out.println("Згенерований матриця"+ Arrays.deepToString(matrixOfNumbers));
        return matrixOfNumbers;
    }

    private static int findMax(int[] arrayOfNumbers) {
        if(arrayOfNumbers.length == 0){
            System.out.println("Схоже, що цей масив пустий. Спочатку вам потрібно в нього додати оцінки");
            return 0;
        } else {
            int max = arrayOfNumbers[0];
            for(int number : arrayOfNumbers){
                if(number > max){
                    max = number;
                }
            }
            return max;
        }
    }

    private static int findMin(int[] arrayOfNumbers) {
        if(arrayOfNumbers.length == 0){
            System.out.println("Схоже, що цей масив пустий. Спочатку вам потрібно в нього додати оцінки");
            return 0;
        } else {
            int min = arrayOfNumbers[0];
            for(int number : arrayOfNumbers){
                if(number < min){
                    min = number;
                }
            }
            return min;
        }
    }
    static Random random = new Random();
}
