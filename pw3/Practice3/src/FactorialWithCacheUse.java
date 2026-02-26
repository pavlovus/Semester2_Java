/*Практичне завдання №3, Вус Павло, ІПЗ-1
Написати тестувальник який демонструє роботу написаних вище класів.
 */
import utils.DataInput;

import java.math.BigInteger;
import java.util.Arrays;

public class FactorialWithCacheUse {
    /**
     * The main method to execute the factorial calculation program.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        FactorialWithCache factorialWithCacheCalculator = new FactorialWithCache();
        Factorial factorialCalculator = new Factorial();
        while (true){
            int choice = DataInput.getInt("Введіть 1, щоб знайти з кешем, 2 - без кешу, 0 - завершити: ");
            if (choice == 1){
                int number = DataInput.getInt("Введіть число, щоб знайти його факторіал(з кешем): ");
                while(number<0 || number>20){
                    number = DataInput.getInt("Введіть число ВІД 1 ДО 20: ");
                }
                BigInteger result = factorialWithCacheCalculator.findFactorial(number);
                System.out.println(result);
                System.out.println(Arrays.toString(FactorialWithCache.factorialCache));
            } else if (choice == 2){
                int number = DataInput.getInt("Введіть число, щоб знайти його факторіал(без кешу): ");
                System.out.println("Факторіал числа "+ number + " : " + factorialCalculator.factorial(number));
            } else if (choice == 0){
                System.out.println("Програма завершена!!!");
                return;
            }
        }
    }
}
