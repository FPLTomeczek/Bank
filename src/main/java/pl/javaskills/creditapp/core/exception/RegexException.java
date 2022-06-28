package pl.javaskills.creditapp.core.exception;

public class RegexException extends ValidationException{
    public RegexException(String message) {
        super(String.format("Field %s regex exception",message));
    }
}
