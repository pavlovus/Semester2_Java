package ua.com.laboratory02;

public class ItemUniquenessException extends IllegalArgumentException {
    public ItemUniquenessException() { super("This item already exists");}
}
