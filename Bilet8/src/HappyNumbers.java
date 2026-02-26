public class HappyNumbers {
    public boolean isHappyNumber(int number) {
        int numberOfDigits = String.valueOf(number).length();
        int sumOfFirstHalf = 0;
        int sumOfSecondHalf = 0;
        int currentNumber = number;

        if (numberOfDigits % 2 != 0) {
            return false;
        }

        for (int i = 1; i <= numberOfDigits / 2; i++) {
            sumOfFirstHalf += currentNumber / (int)Math.pow(10, numberOfDigits - i);
            currentNumber %= (int)Math.pow(10, numberOfDigits - i);
        }

        for (int i = (numberOfDigits / 2) + 1; i <= numberOfDigits; i++) {
            sumOfSecondHalf += currentNumber / (int)Math.pow(10, numberOfDigits - i);
            currentNumber %= (int)Math.pow(10, numberOfDigits - i);
        }

        return sumOfFirstHalf == sumOfSecondHalf;
    }
}
