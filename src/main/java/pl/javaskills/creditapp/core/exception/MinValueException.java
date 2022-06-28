package pl.javaskills.creditapp.core.exception;

public class MinValueException extends ValidationException{
    public MinValueException(String message, int minExpValue) {
        super(String.format("Field %s is less then minValue %d",message, minExpValue));
    }

    public MinValueException(String message,double minExpValue) {
        super(String.format("Field %s is less then minValue %d",message, minExpValue));
    }
}
