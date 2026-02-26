/*Домашнє завдання №1, Вус Павло, ІПЗ-1,завдання №4
 *Написати програму, що визначає чи є введений двомірний масив магічним квадратом (містить однакову суму в усіх стовпчиках, рядках, діагоналях). Має бути два класи MagicSquare та MagicSquareMain
Клас MagicSquare в конструктор має приймати двовимірний масив
Клас MagicSquare має містити метод, що повертає чи це магічний квадрат
В класі MagicSquareMain в окремому методі отримати введений з клавіатури двовимірний масив,
* створити клас MagicSquare та використовуючи відповідний метод вивести в консоль двовимірний масив,
*  та інформацію про те чи введені дані є магічним квадратом
Передбачити різноманітні перевірки на коректність введення даних
*/
public class MagicSquare {
    private int[][] magicSquare;

    //Конструктори
    public MagicSquare() {
        this.magicSquare = new int[0][0];
    }
    public MagicSquare(int[][] matrix) {
        this.magicSquare = matrix;
    }
    //Метод, який перевіряє, чи є магічним квадратом
    public boolean checkForMagicSquare() {
        return checkRowsForMagicSquare(this.magicSquare) && checkColumnsForMagicSquare(this.magicSquare) && checkDiagonalsForMagicSquare(this.magicSquare);
    }

    private boolean checkDiagonalsForMagicSquare(int[][] matrix) {
        if (matrix.length == 0) return true;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum1 += matrix[i][i];
            sum2 += matrix[i][matrix.length - 1 - i];
        }
        return sum1 == sum2;
    }

    private boolean checkColumnsForMagicSquare(int[][] matrix) {
        if (matrix.length == 0) return true;
        int sum1 = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum1 += matrix[row][0];
        }
        for (int col = 1; col < matrix[0].length; col++) {
            int sum2 = 0;
            for (int row = 0; row < matrix[col].length; row++) {
                sum2 += matrix[row][col];
            }
            if (sum1 != sum2) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRowsForMagicSquare(int[][] matrix) {
        if (matrix.length == 0) return true;
        int sum1 = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            sum1 += matrix[0][col];
        }
        for (int row = 1; row < matrix.length; row++) {
            int sum2 = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                sum2 += matrix[row][col];
            }
            if (sum1 != sum2) {
                return false;
            }
        }
        return true;
    }
}
