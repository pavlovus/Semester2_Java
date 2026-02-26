/*Практичне завдання №3, Вус Павло, ІПЗ-1
Створити клас з методом, що буде обраховувати факторіал від 0 до 20 використовуючи кешовані результати обчислення факторіалів.
Тобто якщо клас до цього порахував факторіал 5, то для обрахування факторіала 6 ми можемо скористуватися вже отриманим попереднім результатом.
Для цього в класі реалізувати статичний масив значень факторіала від 0 до 20, і статичну змінну, що буде вказувати на кількість вже обрахованних факторіалів.
При спробі обрахувати факторіал більше 20 або менше 0 видавати помилку.
(в цьому класі немає методу main він буде в подальшому використовуватися в інших програмах).
 */
import java.math.BigInteger;

public class FactorialWithCache {
    private final static int MAXFACTORIAL = 20;
    public static int maxFactorial = 0;
    public static BigInteger[] factorialCache = new BigInteger[21];
    private Factorial factorialCalculator = new Factorial();
    /**
     * Finds the factorial of a given number using caching.
     *
     * @param n the number to compute the factorial for (must be between 0 and MAXFACTORIAL)
     * @return the factorial of the given number as a BigInteger
     * @throws IllegalArgumentException if n is out of range (less than 0 or greater than MAXFACTORIAL)
     */
    public BigInteger findFactorial(int n) {
        if (n < 0 || n > MAXFACTORIAL) {
            throw new IllegalArgumentException("Число повинно бути від 0 до " + MAXFACTORIAL + "!!!");
        }
        if (maxFactorial == 0) {
            return firstFactorial(n);
        } else if (factorialCache[n] != null){
            return factorialCache[n];
        } else {
            return factorialFromCache(n);
        }
    }
    /**
     * Computes and stores the first factorial values in the cache.
     *
     * @param n the number up to which factorials should be computed and stored
     * @return the factorial of the given number
     */
    private BigInteger firstFactorial(int n) {
        for (int i = 0; i <= n; i++) {
            factorialCache[i] = factorialCalculator.factorial(i);
        }
        return factorialCache[n];
    }
    /**
     * Computes factorials using previously cached values for optimization.
     *
     * @param n the number to compute the factorial for
     * @return the factorial of the given number
     */
    private BigInteger factorialFromCache(int n) {
        for (int i = maxFactorial + 1; i <= n; i++) {
            factorialCache[i] = factorialCache[i - 1].multiply(BigInteger.valueOf(i));
        }
        maxFactorial = n;
        return factorialCache[n];
    }
}

