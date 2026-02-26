/*Практичне завдання №1, Вус Павло, ІПЗ-1,завдання №3
 * Дано цілочисельну прямокутну матрицю.
        1). Розташувати стовпчики заданої матриці за зростанням сум модулів їх від’ємних непарних елементів.
        2). Знайти суму елементів у тих стовпчиках, які містять хоча б один від’ємний елемент */
import utils.DataInput;

import java.util.Arrays;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        while (true){
            int[][] matrix = createMatrix();
            transformMatrix(matrix);
            System.out.println("Розташуваня стовпчиків заданої матриці за зростанням сум модулів їх від’ємних непарних елементів: " + Arrays.deepToString(matrix));
            double specificSum = findSpecificSum(matrix);
            System.out.println("Cума елементів у тих стовпчиках, які містять хоча б один від’ємний елемент: " + specificSum);

            //Запитуємо чи користувач хоче продовжувати
            int choice = DataInput.getInt("Продовжуємо? Введіть 1 для продовження або 0 для виходу: ");
            while(true){
                if(choice == 0){
                    System.out.println("Програма завершена!");
                    break;
                } else if(choice == 1){
                    break;
                } else {
                    choice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу:");
                }
            }
        }
    }

    private static int findSpecificSum(int[][] matrix) {
        int sum = 0;
        for (int column = 0; column < matrix[0].length; column++) {
            boolean hasNegative = false;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][column] < 0) {
                    hasNegative = true;
                }
            }
            if (hasNegative) {
                for (int row = 0; row < matrix.length; row++) {
                    sum += matrix[row][column];
                }
            }
        }
        return sum;
    }

    private static void transformMatrix(int[][] matrix) {
        int columns = matrix[0].length;

        for (int i = 0; i < columns - 1; i++) {
            for (int j = i + 1; j < columns; j++) {
                int sumI = getNegativeOddSum(matrix, i);
                int sumJ = getNegativeOddSum(matrix, j);
                if (sumI > sumJ) {
                    swapColumns(matrix, i, j);
                }
            }
        }

    }

    private static void swapColumns(int[][] matrix, int firstColumn, int secondColumn) {
        for(int i=0; i<matrix.length; i++ ){
            int temp = matrix[i][firstColumn];
            matrix[i][firstColumn] = matrix[i][secondColumn];
            matrix[i][secondColumn] = temp;
        }
    }

    private static int getNegativeOddSum(int[][] matrix, int column) {
        int sum = 0;
        for (int[] row : matrix) {
            if(row[column] % 2 != 0 && row[column] < 0){
                sum += Math.abs(row[column]);
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
        int columns = DataInput.getInt("Введіть к-сть стовпчиків матриці, яку будемо створювати: ");
        while(columns <= 0){
            columns = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
        }
        int rows = DataInput.getInt("Введіть к-сть рядків матриці, яку будемо створювати: ");
        while(rows <= 0){
            rows = DataInput.getInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
        }
        int[][] matrixOfNumbers = new int[rows][columns];
        for (int i=0; i<matrixOfNumbers.length;i++){
            for (int j = 0;j<matrixOfNumbers[i].length;j++){
                matrixOfNumbers[i][j] = random.nextInt(-100, 100);
            }
        }
        System.out.println("Згенерований матриця"+ Arrays.deepToString(matrixOfNumbers));
        return matrixOfNumbers;
    }

    static Random random = new Random();
}
