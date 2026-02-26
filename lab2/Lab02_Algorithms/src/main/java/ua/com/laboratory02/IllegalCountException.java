package ua.com.laboratory02;

public class IllegalCountException extends IllegalArgumentException {
    public IllegalCountException() {
        super("Number is a positive value");
    }
}
