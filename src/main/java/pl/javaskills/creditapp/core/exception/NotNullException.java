package pl.javaskills.creditapp.core.exception;

public class NotNullException extends ValidationException{
    public NotNullException(String message) {
        super(String.format("Field %s is not null",message));
    }
}
