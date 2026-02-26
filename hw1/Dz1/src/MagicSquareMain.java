/*Домашнє завдання №1, Вус Павло, ІПЗ-1,завдання №4
 *Написати програму, що визначає чи є введений двомірний масив магічним квадратом (містить однакову суму в усіх стовпчиках, рядках, діагоналях). Має бути два класи MagicSquare та MagicSquareMain
Клас MagicSquare в конструктор має приймати двовимірний масив
Клас MagicSquare має містити метод, що повертає чи це магічний квадрат
В класі MagicSquareMain в окремому методі отримати введений з клавіатури двовимірний масив,
* створити клас MagicSquare та використовуючи відповідний метод вивести в консоль двовимірний масив,
*  та інформацію про те чи введені дані є магічним квадратом
Передбачити різноманітні перевірки на коректність введення даних
*/
import utils.DataInput;

import java.util.Arrays;

public class MagicSquareMain {
    public static void main(String[] args) {
        System.out.println("Ця програма перевіряє чи введений двомірний масив є квадратом");
        while(true) {
            int[][] matrix = createMatrixOfNumbersManually();
            MagicSquare magicSquare = new MagicSquare(matrix);
            printMatrix(matrix);
            if(magicSquare.checkForMagicSquare()){
                System.out.println("Ця матриця магічний квадрат");
            } else {
                System.out.println("Ця матриця не є магічний квадрат");
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

    private static void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length;i++){
            for (int j = 0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
