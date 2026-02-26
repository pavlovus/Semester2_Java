import java.math.BigInteger;

public class FactorialWithCache {
    private final static int MAXFACTORIAL = 20;
    public static int maxFactorial = 0;
    public static BigInteger[] factorialCache = new BigInteger[21];

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
   
    private BigInteger firstFactorial(int n) {
        factorialCache[0] = new BigInteger("1");
        if(n > 0)
            factorialCache[1] = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            factorialCache[i] = factorialCache[i - 1].multiply(BigInteger.valueOf(i));
        }
        maxFactorial = n;
        return factorialCache[n];
    }
    
    private BigInteger factorialFromCache(int n) {
        factorialCache[1] = new BigInteger("1");
        for (int i = maxFactorial + 1; i <= n; i++) {
            factorialCache[i] = factorialCache[i - 1].multiply(BigInteger.valueOf(i));
        }
        maxFactorial = n;
        return factorialCache[n];
    }
}
