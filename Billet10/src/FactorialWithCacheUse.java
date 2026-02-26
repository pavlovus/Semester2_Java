import utils.DataInput;
import java.math.BigInteger;
import java.util.Arrays;

public class FactorialWithCacheUse {
    public static void main(String[] args) {
        FactorialWithCache factorialWithCacheCalculator = new FactorialWithCache();
        while (true){
            int choice = DataInput.getInt("1 - кеш, 0 - завершити: ");
            if (choice == 1){
                int number = DataInput.getInt("Введіть число, щоб знайти його факторіал: ");
                try {
                    BigInteger result = factorialWithCacheCalculator.findFactorial(number);
                    System.out.println(result);
                    System.out.println(Arrays.toString(FactorialWithCache.factorialCache));
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
