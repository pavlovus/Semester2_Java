package ua.com.laboratory02;

public class GroupUniquenessException extends IllegalArgumentException {
    public GroupUniquenessException() {
        super("Group with such name already exists");
    }
}
