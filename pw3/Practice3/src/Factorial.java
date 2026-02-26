/*Практичне завдання №3, Вус Павло, ІПЗ-1
Створити клас з методом, що буде обраховувати факторіал додатнього цілого числа. Працювати з BigInteger
(в цьому класі немає методу main він буде в подальшому використовуватися в інших програмах).
 */
import java.math.BigInteger;

public class Factorial {
    /**
     * Computes the factorial of a given number.
     *
     * @param number the number to compute the factorial for (must be non-negative)
     * @return the factorial of the given number as a BigInteger
     * @throws IllegalArgumentException if the number is negative
     */
    public  BigInteger factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число повинно бути додатнім!!!");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
