package ua.com.laboratory02;

public class IllegalPriceException extends IllegalArgumentException {
    public IllegalPriceException() {
        super("Price cannot be negative");
    }
}
