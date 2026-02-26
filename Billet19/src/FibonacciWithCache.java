import java.math.BigInteger;

public class FibonacciWithCache {
    private final static int MAXFIBONACCI = 20;
    public static int maxFibonacci = 0;
    public static BigInteger[] fibonacciCache = new BigInteger[MAXFIBONACCI + 1];

    public BigInteger findFibonacci(int n) {
        if (n < 0 || n > MAXFIBONACCI) {
            throw new IllegalArgumentException("Число повинно бути від 0 до " + MAXFIBONACCI + "!!!");
        }
        if (maxFibonacci == 0) {
            return firstFibonacci(n);
        } else if (fibonacciCache[n] != null){
            return fibonacciCache[n];
        } else {
            return fibonacciFromCache(n);
        }
    }

    private BigInteger firstFibonacci(int n) {
        fibonacciCache[0] = new BigInteger("0");
        if(n > 0)
            fibonacciCache[1] = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            fibonacciCache[i] = fibonacciCache[i - 1].add(fibonacciCache[i - 2]);
        }
        maxFibonacci = n;
        return fibonacciCache[n];
    }

    private BigInteger fibonacciFromCache(int n) {
        fibonacciCache[1] = new BigInteger("1");
        for (int i = maxFibonacci + 1; i <= n; i++) {
            fibonacciCache[i] = fibonacciCache[i - 1].add(fibonacciCache[i - 2]);
        }
        maxFibonacci = n;
        return fibonacciCache[n];
    }
}
