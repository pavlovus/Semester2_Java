import utils.DataInput;

import java.math.BigInteger;
import java.util.Arrays;

public class FibonacciWithCacheUse {
    public static void main(String[] args) {
        FibonacciWithCache factorialWithCacheCalculator = new FibonacciWithCache();
        while (true){
            int choice = DataInput.getInt("1 - кеш, 0 - завершити: ");
            if (choice == 1){
                int number = DataInput.getInt("Введіть номер(починаючи з нуля) числа Фібоначчі, яке хочете знайти: ");
                try {
                    BigInteger result = factorialWithCacheCalculator.findFibonacci(number);
                    System.out.println(result);
                    System.out.println(Arrays.toString(FibonacciWithCache.fibonacciCache));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 0){
                System.out.println("Програма завершена!!!");
                return;
            }
        }
    }
}
