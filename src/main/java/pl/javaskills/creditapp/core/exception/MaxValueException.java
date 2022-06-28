package pl.javaskills.creditapp.core.exception;

public class MaxValueException extends ValidationException{
    public MaxValueException(String message, int maxExpValue) {
        super(String.format("Field %s is less then maxValue %d",message, maxExpValue));
    }

    public MaxValueException(String message,double maxExpValue) {
        super(String.format("Field %s is less then maxValue %d",message, maxExpValue));
    }
}
